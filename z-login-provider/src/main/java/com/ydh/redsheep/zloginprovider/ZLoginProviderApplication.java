package com.ydh.redsheep.zloginprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ZLoginProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZLoginProviderApplication.class, args);
    }

}
