package com.thread.methods;

import java.util.concurrent.TimeUnit;

/**
 * @Author: w
 * @Date: 2021/6/13 22:47
 * 打断线程运行状态
 */
public class InterruptMethod {

    // 监控器
    private static Thread monitor;

    public static void main(String[] args) {
        //test1();
        //test2();
        test3();
    }

    /**
     * t1线程需要休眠2秒，主线程休眠1秒之后打断t1线程
     */
    private static void test1() {
       Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1");
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
        System.out.println("打断状态："+ thread.isInterrupted());
    }

    /**
     * 打断正常运行的线程
     * 需求：有一个线程一直运行，需要在打断之后不再运行，我们可以使用打断标记来退出运行
     * while(true)是为了让线程一直运行，
     */
    private static void test2() {
        Thread thread = new Thread(() -> {
            while (true) {
                Thread current = Thread.currentThread();
                boolean interrupted = current.isInterrupted();
                if(interrupted) {
                    System.out.println("打断状态："+ interrupted);
                    break;
                }
            }
        },"t1");
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }

    /**
     * 案例：两阶段终止模式
     * 在一个线程t1中如何优雅终止线程t2：给t2一个料理后事的机会
     *
     * 思路（不合适）：
     * 1：使用线程对象的stop方法停止线程：stop会真正杀死线程，如果此时线程锁住了共享资源，那么当他被杀死之后就再也没有机会释放锁，其他线程将永远无法获取锁
     * 2：使用System.exit()方法停止线程：目的是停止一个线程，但这种做法会让整个程序都停止
     *
     * 两阶段终止模式：cpu监控
     *                    while(true)
     *                        |
     *                        |
     *   -----------------------------------------------
     *       有没有被打断
     *   |               |
     *   是              否
     *   |               |
     *   料理后事       睡眠2秒-----------------------------有异常
     *   |               |                                  |
     *   结束循环             执行监控记录                设置打断标志
     */
    private static void test3() {
        start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stop();
    }

    // 开始监控方法
    private static void start() {
        monitor = new Thread(() -> {
            // 让监控线程不断运行
            while (true) {
                // 通过打断标记判断监控是否需要停止
                Thread thread = Thread.currentThread();
                boolean interrupted = thread.isInterrupted();
                if (interrupted) {
                    // 被打断了，料理后事
                    System.out.println("料理后事");
                    // 退出循环
                    break;
                }
                // 未被打断，线程休眠1秒
                try {
                    // 若sleep的时候被打断，会进入异常且打断标记为false，所以需要重新设置打断标记
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("执行监控记录");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    // 设置打断标记
                    thread.interrupt();
                }
            }
        },"monitor");
        monitor.start();
    }

    // 停止方法
    private static void stop() {
        monitor.interrupt();
    }
}


