package com.design.strategy.example3.strategy;

/**
 * @Author: w
 * @Date: 2021/5/27 22:40
 */
public class PekingDuck extends Duck {

    public PekingDuck() {
        flyStrategy = new NoFlyStrategy();
    }

    @Override
    void display() {
        System.out.println("我是北京鸭...");
    }

}
