package com.basic.classAndObject.abstractStudy.basic;

/**
 * @Author: w
 * @Date: 2021/7/24 10:21
 */
public class CommonEmployee extends Employee {

    public CommonEmployee(int id, String name, int salary) {
        super(id, name, salary);
    }

    @Override
    public void work() {
        System.out.println("【普通员工】"+name+"工作中... " + "工资：" + salary);
    }
}
