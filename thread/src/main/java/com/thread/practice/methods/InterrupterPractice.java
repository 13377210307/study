package com.thread.practice.methods;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @Author: w
 * @Date: 2021/6/20 10:29
 * 打断练习
 *
 * 1：打断一个休眠状态的线程会抛出异常；而打断一个正常运行状态的线程则不会；
 *
 */
@Slf4j
public class InterrupterPractice {

    public static void main(String[] args) {
        //demo1();
        demo2();
    }

    // t1线程休眠2秒；主线程在休眠1秒之后进行打断

    /**
     * 需求：t1线程休眠2秒；主线程在休眠1秒之后进行打断
     * 现象：
     * DEBUG 2021-06-20 10:35:40,720 [t1] - 开始休眠...
     * java.lang.InterruptedException: sleep interrupted
     * at java.lang.Thread.sleep(Native Method)
     * at java.lang.Thread.sleep(Thread.java:340)
     * at java.util.concurrent.TimeUnit.sleep(TimeUnit.java:386)
     * at com.thread.practice.methods.InterrupterPractice.lambda$demo1$0(InterrupterPractice.java:25)
     * at java.lang.Thread.run(Thread.java:748)
     * DEBUG 2021-06-20 10:35:41,720 [t1] - 休眠结束...
     * 结论：打断一个休眠状态的线程会抛出异常
     */
    public static void demo1() {

        Thread thread = new Thread(() -> {
            log.debug("开始休眠...");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("休眠结束...");
        }, "t1");
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();
    }

    /**
     * 需求：打断一个正在运行状态的线程；若被打断了，则停止运行
     */
    public static void demo2() {
        Thread thread = new Thread(() -> {
            while (true) {
                log.debug("正在运行....");
                boolean interrupted = Thread.currentThread().isInterrupted();
                if (interrupted) {
                    log.debug("线程被打断..");
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
}
