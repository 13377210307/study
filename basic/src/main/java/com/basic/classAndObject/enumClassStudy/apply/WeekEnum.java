package com.basic.classAndObject.enumClassStudy.apply;

/**
 * @Author: w
 * @Date: 2021/7/25 20:58
 * 声明week枚举类，其中包含星期一至星期天的定义；
 * MONDAY、TUESDAY、WEDNESDAY、THURSDAY、FRIDAY、SATURDAY、SUNDAY
 * 使用values返回所有的枚举类数组，并遍历输出
 */
public enum WeekEnum {

    MONDAY("周一"),
    TUESDAY("周二"),
    WEDNESDAY("周三"),
    THURSDAY("周四"),
    FRIDAY("周五"),
    SATURDAY("周六"),
    SUNDAY("周天");

    private String name;

    WeekEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
