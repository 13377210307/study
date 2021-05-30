package com.design.factory.method;

/**
 * @Author: w
 * @Date: 2021/5/26 8:49
 */
public class BenCarFactory implements CarFactory {

    @Override
    public Car createCar() {
        return new BenCar();
    }
}
