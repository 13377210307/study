package com.design.decorator.example1;

/**
 * @Author: w
 * @Date: 2021/5/31 9:06
 * 武器
 */
public class Weapon implements Equip {


    @Override
    public String description() {
        return "屠龙宝刀";
    }

    @Override
    public Integer calculate() {
        return 20;
    }
}
