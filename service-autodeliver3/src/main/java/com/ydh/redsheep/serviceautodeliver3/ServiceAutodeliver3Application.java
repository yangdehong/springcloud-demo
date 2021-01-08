package com.ydh.redsheep.serviceautodeliver3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients  // 开启Feign 客户端功能
@SpringBootApplication
public class ServiceAutodeliver3Application {

    public static void main(String[] args) {
        SpringApplication.run(ServiceAutodeliver3Application.class, args);
    }

}
