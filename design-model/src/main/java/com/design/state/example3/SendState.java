package com.design.state.example3;

/**
 * @Author: w
 * @Date: 2021/5/29 18:11
 */
public class SendState extends OrderState {

    @Override
    public void handle(Context context) {
        context.setOrderState(new CompleteState());
        System.out.println("当前订单状态为已发货，订单下一状态为完成");
    }
}
