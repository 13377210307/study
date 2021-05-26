package com.design.singleton.method;

/**
 * @Author: w
 * @Date: 2021/5/26 8:48
 */
public class WuLingCarFactory implements CarFactory {

    @Override
    public Car createCar() {
        return new WuLingCar();
    }
}
