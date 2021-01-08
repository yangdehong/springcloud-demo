package com.ydh.redsheep.serviceautodeliver.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/autodeliver")
public class AutodeliverController {


    @Autowired
    private RestTemplate restTemplate;

//    @GetMapping("/checkState")
//    public Integer findResumeOpenState(@RequestParam Long userId) {
//        // 调用远程服务—> 简历微服务接口  RestTemplate  -> JdbcTempate
//        // httpclient封装好多内容进行远程调用
//        Integer forObject = restTemplate.getForObject("http://localhost:8080/resume/openstate?userId=" + userId, Integer.class);
//        return forObject;
//    }

    @Resource
    private DiscoveryClient discoveryClient;

//    /**
//     * 服务注册到Eureka之后的改造
//     * @param userId
//     * @return
//     */
//    @GetMapping("/checkState")
//    public Integer findResumeOpenState(@RequestParam Long userId) {
//        // TODO 从Eureka Server中获取我们关注的那个服务的实例信息以及接口信息
//        // 1、从 Eureka Server中获取service-resume服务的实例信息（使用客户端对象做这件事）
//        List<ServiceInstance> instances = discoveryClient.getInstances("service-resume");
//        // 2、如果有多个实例，选择一个使用(负载均衡的过程)
//        ServiceInstance serviceInstance = instances.get(0);
//        // 3、从元数据信息获取host port
//        String host = serviceInstance.getHost();
//        int port = serviceInstance.getPort();
//        String url = "http://" + host + ":" + port + "/resume/openstate?userId=" + userId;
//        System.out.println("===============>>>从EurekaServer集群获取服务实例拼接的url：" + url);
//        // 调用远程服务—> 简历微服务接口  RestTemplate  -> JdbcTempate
//        // httpclient封装好多内容进行远程调用
//        Integer forObject = restTemplate.getForObject(url, Integer.class);
//        return forObject;
//    }

    /**
     * 使用Ribbon负载均衡
     * @param userId
     * @return
     */
    @GetMapping("/checkState")
    public Integer findResumeOpenState(@RequestParam Long userId) {
        // 使用ribbon不需要我们自己获取服务实例然后选择一个那么去访问了（自己的负载均衡）
        String url = "http://service-resume/resume/openstate?userId=" + userId;  // 指定服务名
        Integer forObject = restTemplate.getForObject(url, Integer.class);
        return forObject;
    }

    /**
     * 1）服务提供者处理超时，熔断，返回错误信息
     * 2）有可能服务提供者出现异常直接抛出异常信息
     *
     * 以上信息，都会返回到消费者这里，很多时候消费者服务不希望把收到异常/错误信息再抛到它的上游去
     *   用户微服务 —  注册微服务  — 优惠券微服务
     *               1 登记注册
     *               2 分发优惠券（并不是核心步骤），这里如果调用优惠券微服务返回了异常信息或者是熔断后的错误信息，这些信息如果抛给用户很不友好
     *                      此时，我们可以返回一个兜底数据，预设的默认值（服务降级）
     */

    /**
     * 提供者模拟处理超时，调用方法添加Hystrix控制
     * @param userId
     * @return
     */
    // 使用@HystrixCommand注解进行熔断控制
    @HystrixCommand(
            // 线程池标识，要保持唯一，不唯一的话就共用了，也就是"舱壁模式"
            threadPoolKey = "findResumeOpenStateTimeout",
            // 线程池细节属性配置
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize",value = "1"), // 线程数
                    @HystrixProperty(name="maxQueueSize",value="20") // 等待队列长度
            },
            // commandProperties熔断的一些细节属性配置
            commandProperties = {
                    // 每一个属性都是一个HystrixProperty
                    @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="2000")
                    // hystrix高级配置，定制工作过程细节
                    // 1、当调用出现问题时，开启一个时间窗(默认10s)
                    // 2、在这个时间窗内，统计**调用次数是否达到最小请求数（区分偶尔出现的网络异常）**?
                    // 2.1、如果没有达到，则重置统计信息，回到第1步
                    // 2.2、如果达到了，则统计失败的请求数占所有请求数的百分比**是否达到阈值（和最小请求数判断的原因差不多）**?
                    // 2.3、如果达到，则跳闸(不再请求对应服务)
                    // 2.4、如果没有达到，则重置统计信息，回到第1步
                    // 3、如果跳闸，则会开启一个活动窗口(默认5s)，每隔5s，Hystrix会让一个请求通过,到达那个问题服务，看是否调用成功，如果成功，重置断路器回到第1步，如果失败，回到第3步
                    // 查看效果 http://localhost:8090/actuator/health
                    ,
                    // 统计时间窗口定义
                    @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds",value = "8000"),
                    // 统计时间窗口内的最小请求数
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "2"),
                    // 统计时间窗口内的错误数量百分比阈值
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50"),
                    // 自我修复时的活动窗口长度
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "3000")
            },
            fallbackMethod = "myFallBack"  // 回退方法，也可以再类上使用@DefaultProperties(defaultFallback = "")
    )
    @GetMapping("/checkStateTimeout")
    public Integer findResumeOpenStateTimeout(@RequestParam Long userId) {
        // 使用ribbon不需要我们自己获取服务实例然后选择一个那么去访问了（自己的负载均衡）
        String url = "http://service-resume/resume/openstate?userId=" + userId;  // 指定服务名
        Integer forObject = restTemplate.getForObject(url, Integer.class);
        return forObject;
    }

    /**
     * 定义回退方法，返回预设默认值
     *    注意：该方法形参和返回值与原始方法保持一致
     * @param userId
     * @return
     */
    public Integer myFallBack(Long userId) {
        return -123; // 兜底数据
    }

}
