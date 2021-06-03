package com.study.newDesignModel.bridge.oldVersion;

/**
 * @Author: w
 * @Date: 2021/6/3 9:10
 */
public abstract class WeixinPay implements Pay {

    @Override
    public String payMoney() {
        return "微信支付";
    }
}
