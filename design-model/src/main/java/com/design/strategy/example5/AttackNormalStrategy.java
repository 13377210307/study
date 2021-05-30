package com.design.strategy.example5;

/**
 * @Author: w
 * @Date: 2021/5/30 14:51
 */
public class AttackNormalStrategy implements AttackStrategy {

    @Override
    public String attack() {
        return "正常攻击";
    }
}
