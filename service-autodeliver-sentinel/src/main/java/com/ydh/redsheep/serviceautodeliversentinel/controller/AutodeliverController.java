package com.ydh.redsheep.serviceautodeliversentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.ydh.redsheep.serviceautodeliversentinel.config.SentinelHandlersClass;
import com.ydh.redsheep.serviceautodeliversentinel.service.ResumeServiceFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/autodeliver")
public class AutodeliverController {

    @Resource
    private ResumeServiceFeignClient resumeServiceFeignClient;

    @GetMapping("/checkState")
    // @SentinelResource注解类似于Hystrix中的@HystrixCommand注解
    @SentinelResource(value = "findResumeOpenState", blockHandlerClass = SentinelHandlersClass.class,
            blockHandler = "handleException", fallbackClass = SentinelHandlersClass.class, fallback = "handleError")
    public Integer findResumeOpenState(@RequestParam Long userId) {
        Integer defaultResumeState = resumeServiceFeignClient.findDefaultResumeState(userId);
        return defaultResumeState;
    }

}
