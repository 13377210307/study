package com.design.decorator.example1;

/**
 * @Author: w
 * @Date: 2021/5/31 9:08
 * 护腕
 */
public class Wrist implements Equip{

    @Override
    public String description() {
        return "强力护腕";
    }

    @Override
    public Integer calculate() {
        return 5;
    }
}
