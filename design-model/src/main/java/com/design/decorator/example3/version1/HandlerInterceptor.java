package com.design.decorator.example3.version1;

/**
 * @Author: w
 * @Date: 2021/5/31 14:11
 * 拦截接口
 * 实际的单点登录开发会基于；org.springframework.web.servlet.HandlerInterceptor 实现。
 */
public interface HandlerInterceptor {

    boolean preHandle(String request, String response, Object handler);

}
