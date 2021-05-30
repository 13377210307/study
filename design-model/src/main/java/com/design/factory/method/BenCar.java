package com.design.factory.method;

import lombok.Data;

/**
 * @Author: w
 * @Date: 2021/5/26 8:47
 */
@Data
public class BenCar implements Car {


    @Override
    public void getCar() {
        System.out.println("奔驰");
    }
}
