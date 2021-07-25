package com.basic.classAndObject.abstractStudy.apply;

/**
 * @Author: w
 * @Date: 2021/7/24 11:28
 */
public class TaskB extends Template{

    @Override
    public void task() {
        Integer count = 0;

        for (int i = 0; i < 700000; i++) {
            count += i;
        }
    }
}
