package com.study.newDesignModel.bridge.oldVersion;

/**
 * @Author: w
 * @Date: 2021/6/3 8:48
 */
public class ALiZhiWenPay extends ALiPay {

    @Override
    public String payMoney() {
        return super.payMoney() + "指纹方式";
    }
}
