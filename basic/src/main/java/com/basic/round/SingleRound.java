package com.basic.round;

import java.util.Scanner;

/**
 * @Author: w
 * @Date: 2021/7/19 22:15
 * 单分支控制
 * 基本语法：
 * if(条件表达式) {
 *     执行代码块;
 * }
 *
 * 当条件表达式为真时，就会执行{}代码块，
 *
 * 案例：输入人的年龄，如果年龄大于18岁，就输出”你年龄大于18，需要对自己的行为负责
 */
public class SingleRound {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您的年龄...");
        int age = scanner.nextInt();
        if (age > 18) {
            System.out.println("你年龄大于18，需要对自己的行为负责");
        }
    }
}
