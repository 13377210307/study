package com.design.singleton.method;

/**
 * @Author: w
 * @Date: 2021/5/26 8:50
 */
public class TestCar {

    public static void main(String[] args) {
        CarFactory carFactory = new BenCarFactory();
        carFactory.createCar().getCar();
    }
}
