package com.ydh.redsheep.hystrixturbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * 能监控多个服务
 * 访问地址 http://localhost:9000/hystrix
 * 检测地址 http://localhost:9001/turbine.stream
 */
@EnableDiscoveryClient
@EnableTurbine  // 开启Turbine聚合功能
@SpringBootApplication
public class HystrixTurbineApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixTurbineApplication.class, args);
    }

}
