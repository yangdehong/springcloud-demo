package com.ydh.redsheep.serviceautodeliver.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// 原来：http://service-resume/resume/openstate?userId= + userId;
// @FeignClient表明当前类是一个Feign客户端，value指定该客户端要请求的服务名称（登记到注册中心上的服务提供者的服务名称）
@FeignClient(value = "service-resume",fallback = ResumeFallback.class, path = "/resume")
//@RequestMapping("/resume")
public interface ResumeServiceFeignClient {

    // Feign要做的事情就是，拼装url发起请求
    // 我们调用该方法就是调用本地接口方法，那么实际上做的是远程请求
    @GetMapping("/openstate")
    Integer findDefaultResumeState(@RequestParam("userId") Long userId);

}
