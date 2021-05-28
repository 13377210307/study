package com.design.strategy.example4.version1;

/**
 * @Author: w
 * @Date: 2021/5/28 8:54
 */
public abstract class Character {

    // 外观方法
    public abstract String display();

    public String move() {
        return "普通移动...";
    }

    public String attack() {
        return "普通攻击...";
    }

}
