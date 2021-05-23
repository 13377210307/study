package com.design.responseLink.example;

import lombok.Data;

/**
 * @Author: w
 * @Date: 2021/5/23 21:59
 *
 * 请求  -》  请求频率  -》  登陆认证  -》  访问权限  -》 敏感词过滤  -》 ...
 * 客户端请求首先看请求频率是否过多，太多直接打回，符合走登陆认证；认证不成功打回，成功走访问权限....
 */
@Data
public class Request {

    // 请求频率
    private Boolean frequentOk;

    // 登陆认证
    private Boolean loginOk;

    // 访问权限
    private Boolean isPermits;

    // 是否包含敏感词汇
    private Boolean containsSensitiveWords;

    // 请求体
    private String requestBody;

    public Request(Boolean frequentOk, Boolean loginOk, Boolean isPermits, Boolean containsSensitiveWords, String requestBody) {
        this.frequentOk = frequentOk;
        this.loginOk = loginOk;
        this.isPermits = isPermits;
        this.containsSensitiveWords = containsSensitiveWords;
        this.requestBody = requestBody;
    }
}
