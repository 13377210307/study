package com.basic.classAndObject.interfaceStudy.apply.interfaceApply;

/**
 * @Author: w
 * @Date: 2021/7/24 12:17
 */
public class OracleConnection implements DBConnection {

    @Override
    public void connect() {
        System.out.println("oracle连接...");
    }

    @Override
    public void close() {
        System.out.println("oracle关闭...");
    }
}
