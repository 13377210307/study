package com.basic.classAndObject.interfaceStudy.apply.interfaceOverloadApply;

/**
 * @Author: w
 * @Date: 2021/7/24 16:45
 */
public class Phone implements Electronic {

    public void call() {
        System.out.println("手机打电话...");
    }


    @Override
    public void work() {
        System.out.println("手机开始工作...");
    }
}
