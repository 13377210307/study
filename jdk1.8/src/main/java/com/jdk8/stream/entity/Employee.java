package com.jdk8.stream.entity;

import lombok.Data;

/**
 * @Author: w
 * @Date: 2021/5/18 21:20
 */
@Data
public class Employee {

    private String name;

    private Integer age;

    private Integer salary;

    private Role role;
}
