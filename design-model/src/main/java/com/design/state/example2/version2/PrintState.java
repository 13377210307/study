package com.design.state.example2.version2;

/**
 * @Author: w
 * @Date: 2021/5/29 17:46
 * 打印状态
 */
public class PrintState extends OrderState{

    @Override
    public void handle(Context context) {
        context.setOrderState(null);
        System.out.println("待归档（打印员）工单没有下一状态了");
    }
}
