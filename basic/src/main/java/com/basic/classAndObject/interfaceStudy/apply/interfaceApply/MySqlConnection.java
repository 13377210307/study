package com.basic.classAndObject.interfaceStudy.apply.interfaceApply;

/**
 * @Author: w
 * @Date: 2021/7/24 12:16
 */
public class MySqlConnection implements DBConnection {

    @Override
    public void connect() {
        System.out.println("mysql连接...");
    }

    @Override
    public void close() {
        System.out.println("mysql关闭...");
    }
}
