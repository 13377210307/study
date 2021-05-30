package com.design.state.example2.version2;

/**
 * @Author: w
 * @Date: 2021/5/29 17:41
 * 新建状态
 */
public class NewState extends OrderState {

    @Override
    public void handle(Context context) {
        context.setOrderState(new DistributeState());
        System.out.println("新建工单（申报人可见）的下一个状态是待分配");
    }
}
