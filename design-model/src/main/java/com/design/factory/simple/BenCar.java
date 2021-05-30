package com.design.factory.simple;

import lombok.Data;

/**
 * @Author: w
 * @Date: 2021/5/25 8:55
 */
@Data
public class BenCar implements Car {

    private String name;

    @Override
    public void getCar() {
        System.out.println("奔驰");
    }
}
