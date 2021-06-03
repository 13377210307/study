package com.study.newDesignModel.bridge.newVersion;

/**
 * @Author: w
 * @Date: 2021/6/3 8:59
 */
public class MiMaPayType implements PayType {

    @Override
    public String payType() {
        return "密码方式";
    }
}
