package com.design.state.example3;

/**
 * @Author: w
 * @Date: 2021/5/29 18:07
 * 待付款
 */
public class NoPayState extends OrderState {


    @Override
    public void handle(Context context) {
        context.setOrderState(new NoSendState());
        System.out.println("当前订单状态为未付款，订单下一状态为待发货");
    }
}
