package com.ydh.redsheep.zlogin.service;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

@Component
public class UserFeignFallback implements UserFeignService {
    @Override
    public Integer register(String email, String password, String code) {
        return -1;
    }

    @Override
    public Integer login(String email, String password, HttpServletResponse response) {
        return -2;
    }

    @Override
    public Integer register(String token) {
        return -3;
    }
}
