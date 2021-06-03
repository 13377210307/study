package com.design.bridge.example3;

/**
 * @Author: w
 * @Date: 2021/6/2 22:53
 */
public class TestPhone {

    public static void main(String[] args) {
        // 用旋转小米手机打电话
        Phone xuanZhuanPhone = new XuanZhuanPhone();
        xuanZhuanPhone.setBrand(new XiaomiBrand());
        xuanZhuanPhone.call();
    }
}
