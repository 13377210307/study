package com.basic.classAndObject.abstractStudy.basic;

/**
 * @Author: w
 * @Date: 2021/7/24 10:22
 */
public class Manager extends Employee{

    // 奖金
    private int bonus;

    public Manager(int id, String name, int salary, int bonus) {
        super(id, name, salary);
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println("【经理】" + name + "工作中... " + "工资：" + salary + "奖金：" + bonus);
    }
}
