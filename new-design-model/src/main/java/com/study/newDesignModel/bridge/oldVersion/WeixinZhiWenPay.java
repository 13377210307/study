package com.study.newDesignModel.bridge.oldVersion;

/**
 * @Author: w
 * @Date: 2021/6/3 9:13
 */
public class WeixinZhiWenPay extends WeixinPay {

    @Override
    public String payMoney() {
        return super.payMoney() + "指纹方式";
    }
}
