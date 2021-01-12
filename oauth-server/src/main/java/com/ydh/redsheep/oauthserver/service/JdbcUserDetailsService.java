package com.ydh.redsheep.oauthserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JdbcUserDetailsService implements UserDetailsService {

    /**
     * 根据username查询出该用户的所有信息，封装成UserDetails类型的对象返回，至于密码，框架会自动匹配
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO 这里可以做数据操作
        return new User("admin","654321",new ArrayList<>());
    }
}
