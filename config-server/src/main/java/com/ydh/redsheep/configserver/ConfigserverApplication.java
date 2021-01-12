package com.ydh.redsheep.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
* 直接访问git上面的文件：http://localhost:9200/main/service-resume-dev.yml
 * 单个服务刷新：http://localhost:8080/actuator/refresh
 * bus刷新：http://localhost:9200/actuator/bus-refresh
* @author : yangdehong
* @date : 2021/1/11 14:25
*/
@EnableDiscoveryClient
@EnableConfigServer  // 开启配置中心功能
@SpringBootApplication
public class ConfigserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigserverApplication.class, args);
    }

}
