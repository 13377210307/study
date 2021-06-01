package com.design.prototype.example1.newVersion;

import lombok.Data;

/**
 * @Author: w
 * @Date: 2021/6/1 22:35
 */
@Data
public class Sheep implements Cloneable{

    private String name;

    private Integer age;

    private String color;

    @Override
    protected Object clone() {
        Sheep sheep = null;
        try {
            sheep = (Sheep)super.clone();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return sheep;
    }
}
