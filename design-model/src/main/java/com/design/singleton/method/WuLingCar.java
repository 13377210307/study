package com.design.singleton.method;

import lombok.Data;

/**
 * @Author: w
 * @Date: 2021/5/26 8:45
 */
@Data
public class WuLingCar implements Car {

    private String name;

    @Override
    public void getCar() {
        System.out.println("五菱宏光");
    }
}
