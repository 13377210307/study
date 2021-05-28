package com.design.strategy.example4.version5;

/**
 * @Author: w
 * @Date: 2021/5/28 10:25
 */
public class AttackNormalStrategy implements AttackStrategy {

    @Override
    public String attack() {
        return "正常攻击";
    }
}
