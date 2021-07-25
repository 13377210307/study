package com.basic.classAndObject.interfaceStudy.basic;

/**
 * @Author: w
 * @Date: 2021/7/24 11:58
 */
public class InterfaceDemoImpl implements InterfaceDemo{

    @Override
    public void interfaceMethod() {
        System.out.println("我是接口中的抽象方法...");
    }

    @Override
    public void defaultMethod() {
        System.out.println("我是重写之后的默认方法...");
    }
}
