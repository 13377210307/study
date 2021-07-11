package com.thread.practice.synchnronizedDemo;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @Author: w
 * @Date: 2021/7/9 8:54
 * 死锁：
 */
@Slf4j
public class DeadLock {

    // 资源1
    private final static Object LOCK1 = new Object();

    // 资源2
    private final static Object LOCK2 = new Object();

    public static void main(String[] args) {
        deadLockVersion1();
    }

    /**
     * 线程1先获取资源a，1秒之后获取资源b，然后结束
     * 线程2先获取资源b，1秒之后获取资源a，然后结束
     */
    private static void deadLockVersion1() {
        new Thread(() -> {
            synchronized (LOCK1) {
                log.debug("获取到资源1...");
                try {
                    TimeUnit.SECONDS.sleep(1);
                    synchronized (LOCK2) {
                        log.debug("获取到资源2...");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (LOCK2) {
                log.debug("获取到资源2...");
            }
            try {
                TimeUnit.SECONDS.sleep(2);
                synchronized (LOCK1) {
                    log.debug("获取到资源1...");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
