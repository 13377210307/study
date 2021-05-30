package com.design.state.example2.version2;

/**
 * @Author: w
 * @Date: 2021/5/29 17:39
 * 抽象工单状态类
 */
public abstract class OrderState {

    // 封装与context一个特定状态相关得行为
    public abstract void handle(Context context);

}
