package com.design.state.example2.version2;

/**
 * @Author: w
 * @Date: 2021/5/29 17:44
 * 检验状态
 */
public class CheckState extends OrderState {

    @Override
    public void handle(Context context) {
        context.setOrderState(new VerifyState());
        System.out.println("待检验（检验员可见）的工单下一状态是待审核");
    }
}
