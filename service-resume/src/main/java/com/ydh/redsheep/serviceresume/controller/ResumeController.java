package com.ydh.redsheep.serviceresume.controller;

import com.ydh.redsheep.serviceresume.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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

        // 模拟处理超时
        /*try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return resumeService.findDefaultResumeByUserId(userId).getIsOpenResume();
//        System.out.println("====>>>>>>>>>>>>>>我是8080，访问到我这里了......");
//        return port;
    }
}
