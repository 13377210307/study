package com.design.visitor.example1;

import lombok.Data;

/**
 * @Author: w
 * @Date: 2021/6/3 9:38
 * 抽象用户
 */
@Data
public abstract class User {

    private String name; // 姓名

    private String identify; // 身份 重点班、普通班 | 特级教师、普通教师、实习教师

    private String clazz; // 班级

    // 暴露给访问者的方法
    abstract void accept(Visitor visitor);
}
