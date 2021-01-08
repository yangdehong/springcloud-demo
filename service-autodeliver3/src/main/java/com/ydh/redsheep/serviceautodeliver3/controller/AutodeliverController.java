package com.ydh.redsheep.serviceautodeliver3.controller;

import com.ydh.redsheep.serviceautodeliver3.service.ResumeServiceFeignClient;
import org.springframework.web.bind.annotation.*;

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
