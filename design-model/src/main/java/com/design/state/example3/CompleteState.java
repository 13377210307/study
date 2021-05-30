package com.design.state.example3;

/**
 * @Author: w
 * @Date: 2021/5/29 18:07
 */
public class CompleteState extends OrderState {
    @Override
    public void handle(Context context) {
        context.setOrderState(new CloseState());
        System.out.println("当前订单状态为完成，订单下一状态为关闭");
    }
}
