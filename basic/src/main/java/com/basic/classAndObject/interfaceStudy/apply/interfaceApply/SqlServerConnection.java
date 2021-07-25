package com.basic.classAndObject.interfaceStudy.apply.interfaceApply;

/**
 * @Author: w
 * @Date: 2021/7/24 12:17
 */
public class SqlServerConnection implements DBConnection {

    @Override
    public void connect() {
        System.out.println("sqlServer连接...");
    }

    @Override
    public void close() {
        System.out.println("sqlServer关闭...");
    }
}
