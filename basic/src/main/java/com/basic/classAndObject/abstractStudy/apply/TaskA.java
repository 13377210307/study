package com.basic.classAndObject.abstractStudy.apply;

/**
 * @Author: w
 * @Date: 2021/7/24 11:27
 */
public class TaskA extends Template{

    @Override
    public void task() {
        int count = 0;
        for (int i = 0; i < 800000; i++) {
            count += i;
        }
    }
}
