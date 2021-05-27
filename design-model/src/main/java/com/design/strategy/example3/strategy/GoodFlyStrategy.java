package com.design.strategy.example3.strategy;

/**
 * @Author: w
 * @Date: 2021/5/27 22:59
 */
public class GoodFlyStrategy implements FlyStrategy {

    @Override
    public void fly() {
        System.out.println("很会飞...");
    }
}
