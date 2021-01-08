package com.ydh.redsheep.serviceresume2.controller;

import com.ydh.redsheep.serviceresume2.service.ResumeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/resume")
public class ResumeController {

    @Resource
    private ResumeService resumeService;


    @Value("${server.port}")
    private Integer port;

    @GetMapping("/openstate")
    public Integer findDefaultResumeState(@RequestParam Long userId) {
        System.out.println("====>>>>>>>>>>>>>>我是8081，访问到我这里了......");
        return port;
    }
}
