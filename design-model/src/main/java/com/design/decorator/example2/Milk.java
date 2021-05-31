package com.design.decorator.example2;

/**
 * @Author: w
 * @Date: 2021/5/31 9:54
 * 牛奶
 */
public class Milk implements Decorator {

    private Drink drink;

    public Milk(Drink drink) {
        this.drink = drink;
    }

    @Override
    public String description() {
        return drink.description() + " +牛奶";
    }

    @Override
    public Integer price() {
        return drink.price() + 2;
    }
}
