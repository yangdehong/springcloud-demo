package com.ydh.redsheep.serviceautodeliver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients  // 开启Feign 客户端功能
@SpringBootApplication
public class ServiceAutodeliverNacosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceAutodeliverNacosApplication.class, args);
    }

}
