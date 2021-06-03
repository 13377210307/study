package com.design.bridge.example3;

/**
 * @Author: w
 * @Date: 2021/6/2 22:50
 * 直立手机
 */
public class ZhiliPhone extends Phone {

    @Override
    void call() {
        System.out.println(super.getBrand().brand() + "直立手机打电话");
    }
}
