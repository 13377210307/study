package com.design.strategy.example1;

import lombok.Data;

/**
 * @Author: w
 * @Date: 2021/5/27 16:15
 * 支付上下文
 */
@Data
public class PayContext {

    // 依赖支付接口属性
    private PayStrategy payStrategy;

    public void payMoney(Double money) {
        payStrategy.pay(money);
    }

}
