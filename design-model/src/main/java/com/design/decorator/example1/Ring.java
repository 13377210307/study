package com.design.decorator.example1;

/**
 * @Author: w
 * @Date: 2021/5/31 9:07
 * 戒指
 */
public class Ring implements Equip {

    @Override
    public String description() {
        return "麻痹戒指";
    }

    @Override
    public Integer calculate() {
        return 5;
    }
}
