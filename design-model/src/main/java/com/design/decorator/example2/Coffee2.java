package com.design.decorator.example2;

/**
 * @Author: w
 * @Date: 2021/5/31 9:51
 */
public class Coffee2 implements Drink {

    @Override
    public String description() {
        return "咖啡2";
    }

    @Override
    public Integer price() {
        return 8;
    }
}
