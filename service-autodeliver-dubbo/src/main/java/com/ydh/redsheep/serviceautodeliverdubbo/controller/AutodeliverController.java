package com.ydh.redsheep.serviceautodeliverdubbo.controller;

import com.ydh.redsheep.servicedubboapi.service.ResumeService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autodeliver")
public class AutodeliverController {

    @Reference(version = "1.0.0")
    private ResumeService resumeService;

    @GetMapping("/checkState")
    public Long findResumeOpenState(@RequestParam Long userId) {
        return resumeService.findDefaultResumeByUserId(userId);
    }
}
