package com.ydh.redsheep.serviceautodeliver.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignLog {
    @Bean
    Logger.Level feignLevel() {
        return Logger.Level.FULL;
    }
}
