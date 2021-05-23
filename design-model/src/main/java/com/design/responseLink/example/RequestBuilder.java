package com.design.responseLink.example;

import lombok.Data;

/**
 * @Author: w
 * @Date: 2021/5/23 22:05
 */
@Data
public class RequestBuilder {

    // 请求频率
    private Boolean frequentOk;

    // 登陆认证
    private Boolean loginOk;

    // 访问权限
    private Boolean isPermits;

    // 是否包含敏感词汇
    private Boolean containsSensitiveWords;

    public RequestBuilder frequentOk(Boolean frequentOk) {
        this.frequentOk = frequentOk;
        return this;
    }

    public RequestBuilder loginOk(Boolean loginOk) {
        this.loginOk = loginOk;
        return this;
    }

    public RequestBuilder isPermits(Boolean isPermits) {
        this.isPermits = isPermits;
        return this;
    }

    public RequestBuilder containsSensitiveWords(Boolean containsSensitiveWords) {
        this.containsSensitiveWords = containsSensitiveWords;
        return this;
    }


}
