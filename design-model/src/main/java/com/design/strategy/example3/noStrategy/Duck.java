package com.design.strategy.example3.noStrategy;

/**
 * @Author: w
 * @Date: 2021/5/27 22:32
 */
public abstract class Duck {

    abstract void display();

    public void quack() {
        System.out.println("鸭子嘎嘎叫...");
    }

    public void swim() {
        System.out.println("鸭子会游泳...");
    }

    public void fly() {
        System.out.println("鸭子会飞...");
    }
}
