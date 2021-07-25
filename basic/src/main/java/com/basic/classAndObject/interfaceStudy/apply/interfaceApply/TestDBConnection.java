package com.basic.classAndObject.interfaceStudy.apply.interfaceApply;


/**
 * @Author: w
 * @Date: 2021/7/24 12:11
 */
public class TestDBConnection {

    public static void main(String[] args) {
        DBConnection mySqlConnection = new MySqlConnection();
        mySqlConnection.connect();
        mySqlConnection.close();
    }
}
