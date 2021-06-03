package com.study.newDesignModel.bridge.newVersion;

/**
 * @Author: w
 * @Date: 2021/6/3 8:56
 */
public class WeixinPay extends Pay {

    @Override
    String payMoney() {
        return "使用微信" +super.getPayType().payType() + "进行支付";
    }
}
