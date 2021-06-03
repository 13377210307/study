package com.study.newDesignModel.bridge.newVersion;

/**
 * @Author: w
 * @Date: 2021/6/3 9:01
 */
public class TestPay {

    public static void main(String[] args) {
        Pay aliPay = new AliPay();
        aliPay.setPayType(new ZhiWenPayType());
        String payMoney = aliPay.payMoney();
        Pay weixinPay = new WeixinPay();
        weixinPay.setPayType(new RenLianPayType());
        String weiXinPayMoney = weixinPay.payMoney();
        System.out.println(payMoney);
        System.out.println(weiXinPayMoney);
    }
}
