package com.ydh.redsheep.zlogin.controller;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.ydh.redsheep.zlogin.pojo.UserPO;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
*
* @author : yangdehong
* @date : 2021/1/9 22:01
*/
@Controller
@RequestMapping("/api/user")
public class UserController {

    private Cache<String, String> codeCache = CacheBuilder.newBuilder().expireAfterAccess(24, TimeUnit.HOURS).build();
    private Cache<String, UserPO> userCache = CacheBuilder.newBuilder().expireAfterAccess(24, TimeUnit.HOURS).build();
    private Cache<String, UserPO> tokenCache = CacheBuilder.newBuilder().expireAfterAccess(24, TimeUnit.HOURS).build();

    @ResponseBody
    @GetMapping(value = "/sendCode")
    public String sendCode(@RequestParam String email){
        // 判断code
        int code = (int)((Math.random()*9+1)*100000);
        codeCache.put(email, String.valueOf(code));
        return String.valueOf(code);
    }

    @ResponseBody
    @GetMapping(value = "/register")
    public Integer register(@RequestParam String email, @RequestParam String password, @RequestParam String code){
        // 判断code
        String existCode = codeCache.getIfPresent(email);
        if (!Objects.equals(existCode, code)) {
            return -1;
        }
        // 插入缓存
        UserPO userPO = new UserPO();
        userPO.setEmail(email);
        userPO.setPassword(password);
        userCache.put(email, userPO);
        return 0;
    }

    @ResponseBody
    @GetMapping(value = "/login")
    public String login(@RequestParam String email, @RequestParam String password, HttpServletResponse response){
        // 插入缓存
        UserPO userPO = userCache.getIfPresent(email);
        if (Objects.nonNull(userPO.getEmail()) && Objects.equals(email, userPO.getEmail())
                && Objects.equals(password, userPO.getPassword())) {
            String token = UUID.randomUUID().toString();
            Cookie cookie = new Cookie("token",token);
            response.addCookie(cookie);
            tokenCache.put(token, userPO);
            return token;
        }
        return "false";
    }

    @ResponseBody
    @GetMapping(value = "/info")
    public String info(@RequestParam String token){
        UserPO userPO = tokenCache.getIfPresent(token);
        return userPO.getEmail();
    }

}
