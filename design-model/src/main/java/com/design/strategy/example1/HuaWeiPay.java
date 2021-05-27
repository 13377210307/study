package com.design.strategy.example1;

/**
 * @Author: w
 * @Date: 2021/5/27 16:14
 */
public class HuaWeiPay implements PayStrategy {

    @Override
    public void pay(Double money) {
        Double realMoney = money * 0.9;
        System.out.println("你本次使用华为共支付了：" + realMoney + "元，一共优惠了："+ (money - realMoney) +"元");
    }
}
