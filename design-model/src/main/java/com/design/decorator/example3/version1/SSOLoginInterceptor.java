package com.design.decorator.example3.version1;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: w
 * @Date: 2021/5/31 14:22
 * 重写SSO拦截器，重写其中的拦截逻辑
 */
public class SSOLoginInterceptor extends SSOInterceptor {

    private static Map<String,Object> authMap = new HashMap<>();

    static {
        authMap.put("zs","queryUserInfo");
        authMap.put("ls","queryUserInfo");
    }

    @Override
    public boolean preHandle(String request, String response, Object handler) {
        // 模拟获取cookie
        String ticket = request.substring(1, 8);
        // 模拟校验
        boolean success = ticket.equals("success");

        // 校验成功，判断是否有权限查看数据
        if (success) {
            String user = request.substring(8);
            return "queryUserInfo".equals(authMap.get(user));
        }else {
            return false;
        }
    }

}
