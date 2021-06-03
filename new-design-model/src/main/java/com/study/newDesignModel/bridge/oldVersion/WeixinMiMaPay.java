package com.study.newDesignModel.bridge.oldVersion;

/**
 * @Author: w
 * @Date: 2021/6/3 9:14
 */
public class WeixinMiMaPay extends WeixinPay {

    @Override
    public String payMoney() {
        return super.payMoney() + "密码支付";
    }
}
