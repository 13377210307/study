package com.design.strategy.example3.noStrategy;

/**
 * @Author: w
 * @Date: 2021/5/27 22:41
 */
public class ToyDuck extends Duck {

    @Override
    void display() {

    }

    @Override
    public void quack() {
        System.out.println("我不是嘎嘎叫...");
    }

    @Override
    public void swim() {
        System.out.println("我不会游泳...");
    }

    @Override
    public void fly() {
        System.out.println("我不会飞行...");
    }
}
