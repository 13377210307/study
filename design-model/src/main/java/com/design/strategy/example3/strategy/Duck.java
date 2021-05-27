package com.design.strategy.example3.strategy;

/**
 * @Author: w
 * @Date: 2021/5/27 22:57
 */
public abstract class Duck {

    // 策略接口
    FlyStrategy flyStrategy;

    QuackStrategy quackStrategy;

    abstract void display();

    public void fly() {
        if (flyStrategy != null) {
            flyStrategy.fly();
        }
    }
}
