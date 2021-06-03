package com.study.newDesignModel.bridge.newVersion;

/**
 * @Author: w
 * @Date: 2021/6/3 8:58
 */
public class ZhiWenPayType implements PayType {

    @Override
    public String payType() {
        return "指纹方式";
    }
}
