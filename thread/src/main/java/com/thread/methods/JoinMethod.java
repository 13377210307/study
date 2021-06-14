package com.thread.methods;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @Author: w
 * @Date: 2021/6/13 22:15
 *
 */
public class JoinMethod {

    private static int r = 0;

    private static int r1 = 0;

    private static int r2 = 0;

    public static void main(String[] args) {
        //test1();
        //joinTest();
        //joinTest1();
        //joinTest2();
        joinTest3();
    }


    /**
     * r结果为0，因为主线程和从线程是并行执行的，从线程休眠一秒，主线程打印结果快于从线程赋值，所以r为0
     */
    private static void test1() {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                r = 10;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        System.out.println(r);
    }

    /**
     * 通过join可以实现主线程打印在从线程执行完之后，谁调用join方法就等待哪个线程执行完
     */
    private static void joinTest() {
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                r = 10;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(r);
    }

    /**
     * 案例：泡面：线程1：烧水需要花费10分钟，线程2：准备面条：需要花费5分钟；主任务：吃上面需要花费多久
     * 线程1，线程2同时启动，t1.join()，主线程先等待t1线程结束；接着t2.join()，主线程等待t2线程结束
     */
    private static void joinTest1() {
        // 准备面
        Thread thread1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                r1 = 10;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1");
        // 烧水
        Thread thread2 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                r2 = 20;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2");
        Long start = System.currentTimeMillis();
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    /**
     * 案例：泡面：线程1：烧水需要花费10分钟，线程2：准备面条：需要花费5分钟；主任务：吃上面需要花费多久
     * 线程1，线程2同时启动，t2.join()，主线程先等待t2线程结束2秒；接着t1.join()，主线程等待t1线程结束1秒，由于t1线程只需要1秒，所以早已结束不需要等待，最后结果为2秒
     */
    private static void joinTest2() {
        // 准备面
        Thread thread1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                r1 = 10;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1");
        // 烧水
        Thread thread2 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                r2 = 20;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2");
        Long start = System.currentTimeMillis();
        thread1.start();
        thread2.start();
        try {
            thread2.join();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    /**
     * 等待n秒
     */
    private static void joinTest3() {
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                r1 = 10;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1");
        Long start = System.currentTimeMillis();
        thread.start();
        // 主线程等待一秒之后进行打印
        try {
            thread.join(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Long end = System.currentTimeMillis();
        System.out.println(r1);
        System.out.println(end - start);
    }
}
