package com.study.newDesignModel.bridge.newVersion;

/**
 * @Author: w
 * @Date: 2021/6/3 8:55
 */
public class AliPay extends Pay {

    @Override
    String payMoney() {
        return "使用支付宝" + super.getPayType().payType() + "进行支付";
    }
}
