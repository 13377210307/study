package com.basic.classAndObject.interfaceStudy.apply.interfaceOverloadApply;

/**
 * @Author: w
 * @Date: 2021/7/24 16:46
 */
public class Camera implements Electronic {

    @Override
    public void work() {
        System.out.println("相机工作...");
    }
}
