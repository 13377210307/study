package com.basic.classAndObject.abstractStudy.basic;

/**
 * @Author: w
 * @Date: 2021/7/24 10:26
 */
public class TestEmployee {

    public static void main(String[] args) {
        Employee commonEmployee = new CommonEmployee(1, "张三", 5000);
        commonEmployee.work();

        Employee manager = new Manager(2, "李四", 10000, 5000);
        manager.work();
    }
}
