package com.basic.classAndObject.interfaceStudy.apply.interfaceOverloadApply;

/**
 * @Author: w
 * @Date: 2021/7/24 16:47
 */
public class TestElectronic {

    public static void main(String[] args) {
        Electronic[] electronics = new Electronic[2];
        electronics[0] = new Phone();
        electronics[1] = new Camera();

        /**
         * 遍历电子设备数组，输出各自工作方式，如果是phone则需要数据打电话功能
         */
        for (int i = 0; i < electronics.length; i++) {
            electronics[i].work();
            if (electronics[i] instanceof Phone) { // 判断该类的运行类型
                ((Phone)electronics[i]).call();
            }
        }
    }
}
