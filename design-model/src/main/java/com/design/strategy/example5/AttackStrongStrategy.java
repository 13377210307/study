package com.design.strategy.example5;

/**
 * @Author: w
 * @Date: 2021/5/30 14:50
 */
public class AttackStrongStrategy implements AttackStrategy {

    @Override
    public String attack() {
        return "强力攻击";
    }
}
