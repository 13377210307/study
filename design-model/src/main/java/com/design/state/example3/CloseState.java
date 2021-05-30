package com.design.state.example3;

/**
 * @Author: w
 * @Date: 2021/5/29 18:07
 */
public class CloseState extends OrderState {

    @Override
    public void handle(Context context) {
        context.setOrderState(null);
        System.out.println("当前订单状态为关闭，无下一状态");
    }
}
