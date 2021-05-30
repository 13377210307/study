package com.design.state.example2.version2;

/**
 * @Author: w
 * @Date: 2021/5/29 17:45
 * 审核状态
 */
public class VerifyState extends OrderState {

    @Override
    public void handle(Context context) {
        context.setOrderState(new PrintState());
        System.out.println("待审核（总工程师可见）工单的下一状态是待归档");
    }
}
