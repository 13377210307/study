package com.netty.chat.server.service;

/**
 * @Author: w
 * @Date: 2021/6/9 22:00
 * 用户管理接口
 */
public interface UserService {

    /**
     * 登陆
     */
    Boolean login(String username,String password);
}
