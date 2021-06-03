package com.study.newDesignModel.bridge.oldVersion;

/**
 * @Author: w
 * @Date: 2021/6/3 8:47
 */
public class ALiPay implements Pay{

    @Override
    public String payMoney() {
        return "支付宝支付";
    }
}
