package com.design.strategy.example4.version2;

/**
 * @Author: w
 * @Date: 2021/5/28 9:00
 */
public class GreenHeadZombie extends Character {

    @Override
    public String display() {
        return "绿头僵尸";
    }

    @Override
    public Integer speed() {
        return 10;
    }
}
