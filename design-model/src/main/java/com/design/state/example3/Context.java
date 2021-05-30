package com.design.state.example3;

import lombok.Data;

/**
 * @Author: w
 * @Date: 2021/5/29 18:04
 */
@Data
public class Context {

    private OrderState orderState;

    public void request() {
        orderState.handle(this);
    }
}
