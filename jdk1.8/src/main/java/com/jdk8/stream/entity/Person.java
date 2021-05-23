package com.jdk8.stream.entity;

import lombok.Data;

/**
 * @Author: w
 * @Date: 2021/5/19 16:12
 */
@Data
public class Person {

    private String name;  // 姓名
    private Integer salary; // 薪资
    private Integer age; // 年龄
    private String sex; //性别
    private String area;  // 地区

    public Person(String name, int salary, int age, String sex, String area) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.sex = sex;
        this.area = area;
    }
}
