package com.basic.round;

import java.util.Scanner;

/**
 * @Author: w
 * @Date: 2021/7/19 22:26
 * 多分支控制
 * 基本语法
 * if(条件表达式1) {
 *      执行代码块1;
 * } else if(条件表达式2) {
 *     执行代码块2;
 * } else {
 *    执行代码块3;
 * }
 *
 * 当条件1满足时，执行代码块1
 * 只有当条件1不满足，条件2满足时会执行代码块2
 * 都不满足的话就执行代码块3
 *
 * 案例：输入马保国的芝麻信用分
 * 1：芝麻分为100，输出信用极好
 * 2：芝麻分为（80，99]，输出信用优秀
 * 3：芝麻分为[60，80]，输出信用一般
 * 4：其他情况，输出信用不合格
 */
public class ManyRound {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("马保国：请输入您的芝麻信用分...");
        int score = scanner.nextInt();
        if (score == 100) {
            System.out.println("信用极好");
        }else if (score > 80 && score <= 99) {
            System.out.println("信用优秀");
        }else if (score >= 60 && score <= 80) {
            System.out.println("信用一般");
        }else {
            System.out.println("信用不合格");
        }
    }
}
