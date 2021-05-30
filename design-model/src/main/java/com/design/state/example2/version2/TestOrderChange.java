package com.design.state.example2.version2;

/**
 * @Author: w
 * @Date: 2021/5/29 17:53
 */
public class TestOrderChange {

    public static void main(String[] args) {
        Context context = new Context();
        context.setOrderState(new NewState());

        context.request();
        context.request();
        context.request();
        context.request();
        context.request();
    }
}
