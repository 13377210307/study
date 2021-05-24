package com.jdk8.practice.stream.entity;

import lombok.Data;

/**
 * @Author: w
 * @Date: 2021/5/24 10:31
 */
@Data
public class Course {

    private String name;

    private Double score;

    public Course(String name, Double score) {
        this.name = name;
        this.score = score;
    }
}
