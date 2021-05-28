package com.design.strategy.example4.version3;

/**
 * @Author: w
 * @Date: 2021/5/28 8:54
 */
public abstract class Character {

    // 外观方法
    public abstract String display();

    public abstract Integer speed();

    // 移动
    public String move() {
        return "普通移动...";
    }

    // 攻击
    public abstract String attack();

}
