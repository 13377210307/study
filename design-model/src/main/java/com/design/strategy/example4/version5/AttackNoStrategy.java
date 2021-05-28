package com.design.strategy.example4.version5;

/**
 * @Author: w
 * @Date: 2021/5/28 10:23
 */
public class AttackNoStrategy implements AttackStrategy {

    @Override
    public String attack() {
        return "无攻击力";
    }
}
