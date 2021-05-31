package com.design.decorator.example2;

/**
 * @Author: w
 * @Date: 2021/5/31 9:50
 */
public class Coffee1 implements Drink {

    @Override
    public String description() {
        return "咖啡1";
    }

    @Override
    public Integer price() {
        return 7;
    }
}
