package com.design.state.example3;

/**
 * @Author: w
 * @Date: 2021/5/29 18:14
 */
public class TestOrderState {

    public static void main(String[] args) {
        Context context = new Context();
        context.setOrderState(new NoPayState());

        context.request();
        context.request();
    }
}
