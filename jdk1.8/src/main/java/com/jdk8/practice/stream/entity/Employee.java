package com.jdk8.practice.stream.entity;

import lombok.Data;

/**
 * @Author: w
 * @Date: 2021/5/22 16:27
 */
@Data
public class Employee {

    private String name;

    private Integer age;

    private Integer salary;

    private String role;

    public Employee(String name, Integer age, Integer salary, String role) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.role = role;
    }
}
