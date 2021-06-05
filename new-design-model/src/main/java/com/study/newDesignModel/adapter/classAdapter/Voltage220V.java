package com.study.newDesignModel.adapter.classAdapter;

/**
 * @Author: w
 * @Date: 2021/6/3 22:44
 * 220v电压
 */
public class Voltage220V {

    public Integer output220() {
        Integer src = 220;
        System.out.println("电压=" + src + "伏");
        return 220;
    }
}
