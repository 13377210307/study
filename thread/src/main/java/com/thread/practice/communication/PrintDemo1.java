package com.thread.practice.communication;

/**
 * @Author: w
 * @Date: 2021/7/11 10:19
 *
 * 编写两个线程,一个线程打印1-52的整数，另一个线程打印字母A-Z。打印顺序为12A34B56C….5152Z。即按照整数和字母的顺序从小到大打印，并且每打印两个整数后，打印一个字母，交替循环打印，直到打印到整数52和字母Z结束。
 * 要求：
 * 1) 编写打印类Printer，声明私有属性index，初始值为1，用来表示是第几次打印。
 * 2) 在打印类Printer中编写打印数字的方法print(int i)，3的倍数就使用wait()方法等待，否则就输出i，使用notifyAll()进行唤醒其它线程。
 * 3) 在打印类Printer中编写打印字母的方法print(char c)，不是3的倍数就等待，否则就打印输出字母c，使用notifyAll()进行唤醒其它线程。
 * 4) 编写测试类Test，创建打印类对象，创建两个线程类对象，启动线程。
 */
public class PrintDemo1 {

    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.printChar();
        printer.printNum();
    }

}

/**
 * 打印类
 */
class Printer {

    private static final Object LOCK = new Object();

    private int index = 1;


    // 打印数字：碰到3的倍数就进行等待
    public void printNum() {
        new Thread(() -> {
            synchronized (LOCK) {
                for (int i = 1; i <= 52; i++) {
                    if (index % 3 == 0) {
                        // 线程等待
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(i);
                    index ++;
                    // 唤醒打印字母线程
                    LOCK.notifyAll();
                }
            }
        }).start();
    }

    // 打印字母
    public void printChar() {
        new Thread(() -> {
            synchronized (LOCK) {
                for (int i = 65; i <= 65 + 26; i++) {
                    if (index % 3 != 0) {
                        // 线程等待
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print((char)(i));
                    index ++;
                    // 唤醒打印数字线程
                    LOCK.notifyAll();
                }
            }
        }).start();
    }
}
