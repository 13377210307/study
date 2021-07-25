package com.basic.classAndObject.abstractStudy.apply;

/**
 * @Author: w
 * @Date: 2021/7/24 11:29
 */
public class TestTemplate {

    public static void main(String[] args) {
        Template taskA = new TaskA();
        taskA.calculateTaskTime();

        Template taskB = new TaskB();
        taskB.calculateTaskTime();
    }
}
