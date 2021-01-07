package com.ydh.redsheep.serviceautodeliver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@EnableEurekaClient  // 开启Eureka Client（Eureka独有）
@EnableDiscoveryClient // 开启注册中心客户端 （通用型注解，比如注册到Eureka、Nacos等）
// 说明：从SpringCloud的Edgware版本开始，不加注解也ok，但是建议大家加上
@SpringBootApplication
public class ServiceAutodeliverApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceAutodeliverApplication.class, args);
    }

    @Bean
    @LoadBalanced // 开启负载均衡
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }


    /**
     * 在被监控的微服务中注册一个serlvet，后期我们就是通过访问这个servlet来获取该服务的Hystrix监控数据的
     * 前提：被监控的微服务需要引入springboot的actuator功能
     * @return
     */
//    @Bean
//    public ServletRegistrationBean getServlet(){
//        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
//        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
//        registrationBean.setLoadOnStartup(1);
//        registrationBean.addUrlMappings("/actuator/hystrix.stream");
//        registrationBean.setName("HystrixMetricsStreamServlet");
//        return registrationBean;
//    }

}
