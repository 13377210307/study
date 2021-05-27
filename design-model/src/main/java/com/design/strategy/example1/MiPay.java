package com.design.strategy.example1;

/**
 * @Author: w
 * @Date: 2021/5/27 16:11
 */
public class MiPay implements PayStrategy {

    @Override
    public void pay(Double money) {
        Double realMoney = money * 0.8;
        System.out.println("你本次使用小米共支付了：" + realMoney + "元，一共优惠了："+ (money - realMoney) +"元");
    }
}
