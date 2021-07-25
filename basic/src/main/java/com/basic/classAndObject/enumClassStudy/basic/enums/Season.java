package com.basic.classAndObject.enumClassStudy.basic.enums;

/**
 * @Author: w
 * @Date: 2021/7/25 19:12
 * 采用枚举创建
 */
public enum Season {

    SPRING("春天","温暖"),
    WINNER("冬天","寒冷"),
    AUTUMN("秋天","凉爽"),
    SUMMER("夏天","炎热");


    private String name;

    private String desc;

    Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
