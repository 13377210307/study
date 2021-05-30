package com.design.state.example2.version2;

import lombok.Data;

/**
 * @Author: w
 * @Date: 2021/5/29 17:40
 */
@Data
public class Context {

    private OrderState orderState;

    // 对请求做处理，并设置下一状态
    public void request() {
        orderState.handle(this);
    }
}
