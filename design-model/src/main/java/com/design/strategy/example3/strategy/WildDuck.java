package com.design.strategy.example3.strategy;

/**
 * @Author: w
 * @Date: 2021/5/27 23:00
 */
public class WildDuck extends Duck {

    // 通过构造器将飞的行为传入
    public WildDuck() {
        flyStrategy = new GoodFlyStrategy();
    }

    @Override
    void display() {
        System.out.println("野鸭...");
    }
}
