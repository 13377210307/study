package com.basic.classAndObject.abstractStudy.basic;

/**
 * @Author: w
 * @Date: 2021/7/24 10:20
 */
public abstract class Employee {

    public int id;

    public String name;

    public int salary;

    public Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public abstract void work();
}
