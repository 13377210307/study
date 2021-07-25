package com.basic.round;

import java.util.Scanner;

/**
 * @Author: w
 * @Date: 2021/7/19 22:21
 * 双分支控制
 * 基本语法
 * if(条件表达式) {
 *      执行代码块1;
 * } else {
 *     执行代码块2;
 * }
 * 当条件表达式为真时，就会执行{}代码块1，否则执行代码块2
 *
 * 案例：案例：输入人的年龄，如果年龄大于18岁，就输出你年龄大于18，需要对自己的行为负责；否则输出你年纪还小，这次先放过你
 */
public class DoubleRound {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您的年龄...");
        int age = scanner.nextInt();
        if (age > 18) {
            System.out.println("你年龄大于18，需要对自己的行为负责");
        }else {
            System.out.println("你年纪还小，这次先放过你");
        }
    }
}
