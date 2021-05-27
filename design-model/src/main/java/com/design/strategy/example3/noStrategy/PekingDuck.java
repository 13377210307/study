package com.design.strategy.example3.noStrategy;

/**
 * @Author: w
 * @Date: 2021/5/27 22:40
 */
public class PekingDuck extends Duck {


    @Override
    void display() {
        System.out.println("我是北京鸭...");
    }

    @Override
    public void fly() {
        System.out.println("我不会飞...");
    }
}
