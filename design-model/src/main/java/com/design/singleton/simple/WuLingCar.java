package com.design.singleton.simple;

import lombok.Data;

/**
 * @Author: w
 * @Date: 2021/5/25 8:54
 */
@Data
public class WuLingCar implements Car {

    private String name;

    @Override
    public void getCar() {
        System.out.println("五菱宏光");
    }
}
