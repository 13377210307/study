package com.design.decorator.example1;

/**
 * @Author: w
 * @Date: 2021/5/31 9:09
 * 鞋子
 */
public class Shoes implements Equip {

    @Override
    public String description() {
        return "急速之靴";
    }

    @Override
    public Integer calculate() {
        return 5;
    }
}
