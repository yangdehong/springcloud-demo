package com.ydh.redsheep.serviceresumenacos2.controller;

import com.ydh.redsheep.serviceresumenacos2.service.ResumeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/resume")
public class ResumeController {

    @Resource
    private ResumeService resumeService;


    @Value("${server.port}")
    private Integer port;

    @GetMapping("/openstate")
    public Integer findDefaultResumeState(@RequestParam Long userId) {
        // 模拟处理超时
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        resumeService.findDefaultResumeByUserId(userId);
        log.debug("====>>>>>>>>>>>>>>我是8080，访问到我这里了......");
        return port;
    }
}
