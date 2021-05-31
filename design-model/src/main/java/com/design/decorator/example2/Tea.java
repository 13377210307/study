package com.design.decorator.example2;

/**
 * @Author: w
 * @Date: 2021/5/31 9:56
 */
public class Tea implements Decorator {

    private Drink drink;

    public Tea(Drink drink) {
        this.drink = drink;
    }

    @Override
    public String description() {
        return drink.description() + " +加茶";
    }

    @Override
    public Integer price() {
        return drink.price() + 1;
    }
}
