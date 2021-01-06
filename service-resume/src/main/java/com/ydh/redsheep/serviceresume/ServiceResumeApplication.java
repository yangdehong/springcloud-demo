package com.ydh.redsheep.serviceresume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = "com.ydh.redsheep.*.mapper")
@SpringBootApplication
public class ServiceResumeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceResumeApplication.class, args);
    }

}
