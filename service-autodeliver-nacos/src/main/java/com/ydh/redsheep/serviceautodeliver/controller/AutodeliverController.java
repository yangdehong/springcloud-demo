package com.ydh.redsheep.serviceautodeliver.controller;

import com.ydh.redsheep.serviceautodeliver.service.ResumeServiceFeignClient;
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
    public Integer findResumeOpenState(@RequestParam Long userId) {
        Integer defaultResumeState = resumeServiceFeignClient.findDefaultResumeState(userId);
        return defaultResumeState;
    }
}
