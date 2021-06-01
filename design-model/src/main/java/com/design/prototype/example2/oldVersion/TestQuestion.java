package com.design.prototype.example2.oldVersion;

/**
 * @Author: w
 * @Date: 2021/6/1 22:50
 */
public class TestQuestion {

    public static void main(String[] args) {
        QuestionBankService questionBankService = new QuestionBankService();
        System.out.println(questionBankService.createPaper("花花", "1000001921032"));
        System.out.println(questionBankService.createPaper("豆豆", "1000001921051"));
        System.out.println(questionBankService.createPaper("大宝", "1000001921987"));
    }
}
