package com.design.decorator.example2;

/**
 * @Author: w
 * @Date: 2021/5/31 9:52
 */
public class Coffee3 implements Drink {

    @Override
    public String description() {
        return "咖啡3";
    }

    @Override
    public Integer price() {
        return 9;
    }
}
