package com.jdk8.stream.entity;

import lombok.Data;

/**
 * @Author: w
 * @Date: 2021/5/14 9:43
 */
@Data
public class Dish {

    private String name;  // 名称

    private boolean vegetarian;   // 是否为蔬菜

    private int calories;  // 卡路里

    private Type type;  // 菜肴类型
}
