package com.ydh.redsheep.zipkinserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin2.server.internal.EnableZipkinServer;

/**
* http://localhost:9411/
 * 线上可以使用zipin的jar直接安装
* @author : yangdehong
* @date : 2021/1/12 16:55
*/
@EnableZipkinServer // 开启Zipkin 服务器功能
@SpringBootApplication
public class ZipkinServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinServerApplication.class, args);
    }

}
