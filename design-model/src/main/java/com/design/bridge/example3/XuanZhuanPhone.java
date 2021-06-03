package com.design.bridge.example3;

/**
 * @Author: w
 * @Date: 2021/6/2 22:50
 * 旋转手机
 */
public class XuanZhuanPhone extends Phone {

    @Override
    void call() {
        System.out.println(super.getBrand().brand() + "旋转手机打电话");
    }
}
