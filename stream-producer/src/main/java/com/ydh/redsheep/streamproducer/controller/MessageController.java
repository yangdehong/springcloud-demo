package com.ydh.redsheep.streamproducer.controller;

import com.ydh.redsheep.streamproducer.service.MessageProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/")
public class MessageController {

    @Resource
    private MessageProducer messageProducer;

    @GetMapping("/test")
    public void findResumeOpenState() {
        messageProducer.sendMessage("hello word");
    }

}
