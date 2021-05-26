package com.design.responseLink.example4;

/**
 * @Author: w
 * @Date: 2021/5/26 14:36
 */
public class TestExpense {

    public static void main(String[] args) {
        // 初始化责任链
        ManagerHandler managerHandler = new ManagerHandler();
        DivideHandler divideHandler = new DivideHandler();
        BossHandler bossHandler = new BossHandler();

        managerHandler.setNext(divideHandler);
        divideHandler.setNext(bossHandler);

        managerHandler.handExpense(2000);
    }
}
