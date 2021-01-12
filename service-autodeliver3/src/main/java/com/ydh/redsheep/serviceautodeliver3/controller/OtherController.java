package com.ydh.redsheep.serviceautodeliver3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/other")
public class OtherController {

    @GetMapping("/test")
    public String findResumeOpenState() {
        return "other test";
    }

}
