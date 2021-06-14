package com.thread.methods;

/**
 * @Author: w
 * @Date: 2021/6/13 18:22
 * 直接调用run方法时还是用main线程去同步执行的，只有调用start方法才会创建一个新的线程去异步执行方法体
 */
public class StartAndRun {

    public static void main(String[] args) {
        threadRun();
        threadStart();
    }

    // 直接调用run方法
    private static void threadRun() {
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "线程：running....");
        });
        thread.run();
        System.out.println("do other things");
    }

    // 调用start方法
    private static void threadStart() {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "线程：running....");
        }).start();
        System.out.println("do other things");
    }
}
