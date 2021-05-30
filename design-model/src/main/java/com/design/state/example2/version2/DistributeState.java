package com.design.state.example2.version2;

/**
 * @Author: w
 * @Date: 2021/5/29 17:43
 * 待分配状态
 */
public class DistributeState extends OrderState{

    @Override
    public void handle(Context context) {
        context.setOrderState(new CheckState());
        System.out.println("待分配（科室主任可见）的任务下一个状态是待检验");
    }
}
