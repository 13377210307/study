package com.design.strategy.example4.version4;

/**
 * @Author: w
 * @Date: 2021/5/28 9:18
 */
public class ShortLegZombie extends Character {

    @Override
    public String display() {
        return "短腿僵尸";
    }

    @Override
    public Integer speed() {
        return 5;
    }

    @Override
    public String move() {
        return "缓慢移动";
    }

    @Override
    public String attack() {
        return "强力攻击";
    }
}
