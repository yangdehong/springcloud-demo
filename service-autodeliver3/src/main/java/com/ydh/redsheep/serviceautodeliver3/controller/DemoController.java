package com.ydh.redsheep.serviceautodeliver3.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/test")
    public String findResumeOpenState() {
        Object details = SecurityContextHolder.getContext().getAuthentication().getDetails();
        System.out.println(details);
        return "other test";
    }

}
