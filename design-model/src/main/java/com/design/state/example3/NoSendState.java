package com.design.state.example3;

/**
 * @Author: w
 * @Date: 2021/5/29 18:07
 */
public class NoSendState extends OrderState {

    @Override
    public void handle(Context context) {
        // 设置下一状态
        context.setOrderState(new SendState());
        System.out.println("当前订单状态为待发货，订单下一状态为已发货");
    }
}
