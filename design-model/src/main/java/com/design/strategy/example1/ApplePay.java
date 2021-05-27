package com.design.strategy.example1;

/**
 * @Author: w
 * @Date: 2021/5/27 16:14
 */
public class ApplePay implements PayStrategy {

    @Override
    public void pay(Double money) {
        Double realMoney = money * 0.5;
        System.out.println("你本次使用苹果共支付了：" + realMoney + "元，一共优惠了："+ (money - realMoney) +"元");
    }
}
