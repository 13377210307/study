package com.basic.classAndObject.enumClassStudy.basic.consumeEnum;

/**
 * @Author: w
 * @Date: 2021/7/25 18:59
 * 自定义枚举类
 * 季节枚举类：季节只有四个，不允许修改，所以为只读方式，由自身去实例化
 */
public class Season {

    private String name;

    private String desc;

    // 构造器私有化
    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    // get方法
    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    // 自身创建
    public final static Season SPRING = new Season("春天","温暖");
    public final static Season WINNER = new Season("冬天","寒冷");
    public final static Season AUTUMN = new Season("秋天","凉爽");
    public final static Season SUMMER = new Season("夏天","炎热");
}
