package com.design.factory.simple;

/**
 * @Author: w
 * @Date: 2021/5/25 8:57
 */
public class CarFactory {

    public Car createCar(String name) {

        Car car = null;
        switch (name) {
            case "五菱": car = new WuLingCar(); break;
            case "奔驰": car = new BenCar(); break;
        }
        return car;
    }


}
