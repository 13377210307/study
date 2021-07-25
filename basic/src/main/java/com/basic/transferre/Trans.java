package com.basic.transferre;

/**
 * @Author: w
 * @Date: 2021/7/18 15:20
 * 转义字符
 * 1：\t：一个制表位，实现对齐功能
 * 2：\n：换行符
 * 3：\\：一个\
 * 4：\"：一个"
 * 5：\'：一个'
 * 6：\r：一个回车
 */
public class Trans {

    public static void main(String[] args) {
        trans1();
        trans2();
        trans3();
        trans4();
        trans5();
        trans6();

    }

    // \t
    private static void trans1() {
        System.out.println("您好\t您好");
    }

    // \n
    private static void trans2() {
        System.out.println("您好\n您好");
    }

    // \\
    private static void trans3() {
        System.out.println("您好\\您好");
    }

    // \"
    private static void trans4() {
        System.out.println("您好\"您好");
    }

    // \'
    private static void trans5() {
        System.out.println("您好\'您好");
    }

    // \r
    private static void trans6() {
        System.out.println("您好\r哈哈");
    }
}
