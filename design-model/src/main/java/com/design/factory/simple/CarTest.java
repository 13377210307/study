package com.design.factory.simple;

/**
 * @Author: w
 * @Date: 2021/5/26 8:40
 */
public class CarTest {

    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        Car car = carFactory.createCar("五菱");
        car.getCar();
    }
}
