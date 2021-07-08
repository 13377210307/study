package com.thread.jmm;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @Author: w
 * @Date: 2021/7/6 22:28
 * 可见性
 */
@Slf4j
public class CanSeeDemo {

    private static boolean run = true;

    private volatile static boolean newRun = true;

    private final static Object LOCK = new Object();

    public static void main(String[] args) {
        //version1();
        //version2();
        version3();
    }

    /**
     * 线程并不会停下来
     * 原因：
     * 1：初始状态，线程t刚开始从主存中读取了run的值到工作内存中
     * 2：由于线程t需要频繁从主内存中读取run的值，JIT编译器会将run的值缓存至自己的工作内存中的高速缓存中，减少对主存中run的访问，提高效率
     * 3：1秒之后，主线程修改run的值，并同步至主存，而线程t是从自己的工作内存中的高速缓存中读取这个变量的值，所以结果永远是旧值
     */
    private static void version1() {
        new Thread(() -> {
            while (run) {
                log.debug("running....");
            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        run = false;
        log.debug("stop running...");
    }

    /**
     * 解决：通过volatile修饰变量
     */
    private static void version2() {
        new Thread(() -> {
            while (newRun) {
                log.debug("running....");
            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        newRun = false;
        log.debug("stop running...");
    }

    /**
     * 解决：通过synchronized加锁；synchronized也可以保证线程可见性、但是synchronized需要创建monitor监视器，相对于volatile较重
     */
    private static void version3() {
        new Thread(() -> {
            while (true) {
                synchronized (LOCK) {
                    if (!run) {
                        break;
                    }
                    log.debug("running....");
                }
            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (LOCK) {
            run = false;
        }
        log.debug("stop running...");
    }
}
