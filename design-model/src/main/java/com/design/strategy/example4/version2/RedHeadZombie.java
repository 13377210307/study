package com.design.strategy.example4.version2;

/**
 * @Author: w
 * @Date: 2021/5/28 8:57
 */
public class RedHeadZombie extends Character {

    @Override
    public String display() {
        return "红头僵尸";
    }

    @Override
    public Integer speed() {
        return 20;
    }
}
