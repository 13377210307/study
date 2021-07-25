package com.basic.classAndObject.interfaceStudy.basic;

/**
 * @Author: w
 * @Date: 2021/7/24 11:52
 * 静态方法与默认方法都是在jdk1.8之后有的
 */
public interface InterfaceDemo {
     // 成员变量
    int a = 10;

    // 方法
    void interfaceMethod();

    // 默认方法
    default void defaultMethod() {
         System.out.println("我是接口中的默认实现方法...");
    }

    // 静态方法
    static void staticMethod() {
         System.out.println("我是接口中的静态方法...");
    }
}
