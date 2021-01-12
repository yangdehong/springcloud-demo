package com.ydh.redsheep.oauthserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
/**
* 获取token：http://localhost:9999/oauth/token?client_secret=abcxyz&grant_type=password&username=admin&password=123456&client_id=client_ydh
 * 建议token：http://localhost:9999/oauth/check_token?token=102ea2f0-55b0-4e81-81bf-83f57ed28d06
 * 刷新token：http://localhost:9999/oauth/token?grant_type=refresh_token&client_id=client_ydh&client_secret=abcxyz&refresh_token=8aa99733-3a2b-4ce3-9cf2-1060feca84d6
* @author : yangdehong
* @date : 2021/1/12 19:15
*/
@EnableDiscoveryClient
@SpringBootApplication
public class OauthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OauthServerApplication.class, args);
    }

}
