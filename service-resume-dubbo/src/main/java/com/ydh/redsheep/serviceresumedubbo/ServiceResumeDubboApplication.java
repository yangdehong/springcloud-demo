package com.ydh.redsheep.serviceresumedubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@EnableDiscoveryClient
@MapperScan(basePackages = "com.ydh.redsheep.*.mapper")
@SpringBootApplication
public class ServiceResumeDubboApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceResumeDubboApplication.class, args);
    }

}
