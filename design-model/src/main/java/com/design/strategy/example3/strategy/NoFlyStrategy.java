package com.design.strategy.example3.strategy;

/**
 * @Author: w
 * @Date: 2021/5/27 22:58
 */
public class NoFlyStrategy implements FlyStrategy {

    @Override
    public void fly() {
        System.out.println("不会飞");
    }
}
