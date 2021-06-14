package com.netty.chat.server.service.impl;

import com.netty.chat.server.service.UserService;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: w
 * @Date: 2021/6/9 22:01
 */
public class UserServiceMemoryImpl implements UserService {

    private Map<String,String> allUserMap = new ConcurrentHashMap<>();

    {
        allUserMap.put("zs","123");
        allUserMap.put("ls","123");
        allUserMap.put("ww","123");
        allUserMap.put("zl","123");
        allUserMap.put("tq","123");
    }

    @Override
    public Boolean login(String username, String password) {
        String pass = allUserMap.get(username);
        return password.equals(pass);
    }
}
