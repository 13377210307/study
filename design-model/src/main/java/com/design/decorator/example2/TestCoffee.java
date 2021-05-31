package com.design.decorator.example2;

/**
 * @Author: w
 * @Date: 2021/5/31 10:00
 */
public class TestCoffee {

    public static void main(String[] args) {
        System.out.println("来一杯加两勺糖和一杯牛奶的咖啡1");
        Drink coffee1 = new Sugar(new Sugar(new Milk(new Coffee1())));

        System.out.println("描述："+coffee1.description());
        System.out.println("价钱："+coffee1.price());
    }
}
