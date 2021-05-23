package com.jdk8.lambda.study;

/**
 * @Author: w
 * @Date: 2021/5/16 19:36
 * lambda表达式的基础语法：箭头函数
 * 左侧：lambda表达式的参数列表
 * 右侧：lambda表达式所需要执行的功能，即函数体
 *
 * 语法格式一：无参数，无返回值：() -> System.out.println("hello Lambda")
 *
 * 语法格式二：有参数，无返回值：(x) -> System.out.println("x")
 *
 * 语法格式三：多个参数：有返回值：(x,y) -> {System.out.println("x");System.out.println("y")}
 *
 * 语法格式四：参数类型可以省略不写，由jvm通过上下文进行推断
 *
 * lambda表达式需要函数式接口的支持：若接口中只有一个抽象方法时就称为函数式接口
 */
public class LambdaBasic {

    private static void test1() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello Lambda");
            }
        };

        r.run();
        System.out.println("===========================================");

        Runnable r1 = () -> System.out.println("hello Lambda");
        r1.run();
    }
}
