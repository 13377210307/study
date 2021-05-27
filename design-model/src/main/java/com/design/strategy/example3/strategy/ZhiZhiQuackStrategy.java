package com.design.strategy.example3.strategy;

/**
 * @Author: w
 * @Date: 2021/5/27 23:02
 */
public class ZhiZhiQuackStrategy implements QuackStrategy {
    @Override
    public void quack() {
        System.out.println("吱吱叫...");
    }
}
