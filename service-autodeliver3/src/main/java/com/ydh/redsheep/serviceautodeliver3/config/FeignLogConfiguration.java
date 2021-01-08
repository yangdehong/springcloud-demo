package com.ydh.redsheep.serviceautodeliver3.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
* feign日志设置
* @author : yangdehong
* @date : 2021/1/8 16:23
*/
@Configuration
public class FeignLogConfiguration {
    @Bean
    Logger.Level feignLevel() {
        return Logger.Level.FULL;
    }
}
