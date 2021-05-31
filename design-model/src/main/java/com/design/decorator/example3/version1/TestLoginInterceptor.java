package com.design.decorator.example3.version1;

/**
 * @Author: w
 * @Date: 2021/5/31 14:19
 */
public class TestLoginInterceptor {

    public static void main(String[] args) {
        HandlerInterceptor ssoLoginInterceptor = new SSOLoginInterceptor();
        String request = "1successzs";
        boolean success = ssoLoginInterceptor.preHandle(request, "response", "handler");
        System.out.println("登录校验：" + request + (success ? " 放行" : " 拦截"));
    }
}
