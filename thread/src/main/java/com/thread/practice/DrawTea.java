package com.thread.practice;

import java.util.concurrent.TimeUnit;

/**
 * @Author: w
 * @Date: 2021/6/14 10:29
 * 泡茶练习
 * 1：步骤：烧水；洗水壶、茶杯、茶壶；
 * 2：实现
 * 新建两个线程：线程1：洗水壶、烧开水；线程2：洗茶壶、洗茶叶、拿茶叶
 */
public class DrawTea {

    public static void main(String[] args) {
        Long start = System.currentTimeMillis();
        Thread thread = boilingWater();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread thread1 = prepareTea(thread);
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Long end = System.currentTimeMillis();
        System.out.println(end - start);

    }

    // 烧水线程：1：洗水壶：1分钟；烧水：5分钟
    private static Thread boilingWater() {
        Thread thread = new Thread(() -> {
            try {
                // 洗水壶
                System.out.println("正在洗水壶...");
                TimeUnit.SECONDS.sleep(1);
                // 烧水
                System.out.println("正在烧水...");
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"boilingWater");
        thread.start();
        return thread;
    }

    // 准备茶叶、洗茶叶之类
    private static Thread prepareTea(Thread boilingWaterThread) {
        Thread thread = new Thread(() -> {
            try {
                // 洗茶壶：1分钟
                System.out.println("正在洗茶壶...");
                TimeUnit.SECONDS.sleep(1);
                // 洗茶叶：1分钟
                System.out.println("正在洗茶叶...");
                TimeUnit.SECONDS.sleep(1);
                // 拿茶叶：1分钟
                System.out.println("正在拿茶叶...");
                TimeUnit.SECONDS.sleep(1);
                boilingWaterThread.join();
                System.out.println("泡茶...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"prepareTea");
        thread.start();
        return thread;
    }
}
