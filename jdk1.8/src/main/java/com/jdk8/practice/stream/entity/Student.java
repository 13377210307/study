package com.jdk8.practice.stream.entity;

import lombok.Data;

import java.util.List;

/**
 * @Author: w
 * @Date: 2021/5/24 10:30
 */
@Data
public class Student {

    private String name;

    private String className;

    private Double score;

    private List<Course> courses;

    public Student(String name, String className, Double score, List<Course> courses) {
        this.name = name;
        this.className = className;
        this.score = score;
        this.courses = courses;
    }
}
