package com.study.newDesignModel.bridge.oldVersion;


/**
 * @Author: w
 * @Date: 2021/6/3 9:08
 */
public class AliMiMaPay extends ALiPay {

    @Override
    public String payMoney() {
        return super.payMoney() + "密码方式";
    }
}
