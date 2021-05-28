package com.design.strategy.example4.version4;

/**
 * @Author: w
 * @Date: 2021/5/28 8:54
 */
public abstract class Character {

    // 外观方法
    public abstract String display();

    public abstract Integer speed();

    // 移动
    public abstract String move();

    // 攻击
    public abstract String attack();

}
