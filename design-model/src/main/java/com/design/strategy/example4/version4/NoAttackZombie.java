package com.design.strategy.example4.version4;

/**
 * @Author: w
 * @Date: 2021/5/28 9:20
 */
public class NoAttackZombie extends Character {
    @Override
    public String display() {
        return "无攻击力僵尸";
    }

    @Override
    public Integer speed() {
        return 10;
    }

    @Override
    public String move() {
        return "普通移动";
    }

    @Override
    public String attack() {
        return "无攻击力";
    }
}
