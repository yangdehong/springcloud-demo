package com.ydh.redsheep.hystrixdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 只能监控单个服务
 * 访问地址 http://localhost:9000/hystrix
 * 检测地址 http://localhost:8090/actuator/hystrix.stream
 */
@EnableDiscoveryClient
@EnableHystrixDashboard  // 开启hystrix dashboard
@SpringBootApplication
public class HystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardApplication.class, args);
    }

}
