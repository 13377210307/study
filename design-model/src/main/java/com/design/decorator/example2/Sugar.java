package com.design.decorator.example2;

/**
 * @Author: w
 * @Date: 2021/5/31 9:59
 * 糖
 */
public class Sugar implements Decorator {

    private Drink drink;

    public Sugar(Drink drink) {
        this.drink = drink;
    }

    @Override
    public String description() {
        return drink.description() + " +糖";
    }

    @Override
    public Integer price() {
        return drink.price() + 1;
    }
}
