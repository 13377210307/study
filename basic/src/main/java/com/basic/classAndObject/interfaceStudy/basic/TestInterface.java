package com.basic.classAndObject.interfaceStudy.basic;

/**
 * @Author: w
 * @Date: 2021/7/24 12:01
 */
public class TestInterface {

    public static void main(String[] args) {
        InterfaceDemo interfaceDemo = new InterfaceDemoImpl();
        InterfaceDemo.staticMethod();
        interfaceDemo.interfaceMethod();
        interfaceDemo.defaultMethod();
    }
}
