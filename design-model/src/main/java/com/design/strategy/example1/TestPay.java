package com.design.strategy.example1;

/**
 * @Author: w
 * @Date: 2021/5/27 16:17
 */
public class TestPay {

    public static void main(String[] args) {
        // 创建支付上下文
        PayContext payContext = new PayContext();
        payContext.setPayStrategy(new HuaWeiPay()); // 设置华为支付
        payContext.payMoney(200.0);
    }
}
