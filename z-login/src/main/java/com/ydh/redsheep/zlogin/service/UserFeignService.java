package com.ydh.redsheep.zlogin.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;

@FeignClient(value = "login",fallback = UserFeignFallback.class, path = "/api/user")
public interface UserFeignService {

    @GetMapping("/register")
    Integer register(@RequestParam String email, @RequestParam String password, @RequestParam String code);
    @GetMapping("/login")
    Integer login(@RequestParam String email, @RequestParam String password, HttpServletResponse response);
    @GetMapping("/info")
    Integer register(@RequestParam String token);

}
