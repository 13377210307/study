package com.design.bridge.example3;

/**
 * @Author: w
 * @Date: 2021/6/2 22:49
 * 折叠手机
 */
public class ZhediePhone extends Phone {

    @Override
    void call() {
        System.out.println(super.getBrand().brand() + "折叠手机打电话");
    }
}
