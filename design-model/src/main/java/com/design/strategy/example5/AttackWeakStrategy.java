package com.design.strategy.example5;

/**
 * @Author: w
 * @Date: 2021/5/30 14:52
 */
public class AttackWeakStrategy implements AttackStrategy {

    @Override
    public String attack() {
        return "柔弱攻击";
    }
}
