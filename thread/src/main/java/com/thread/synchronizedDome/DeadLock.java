package com.thread.synchronizedDome;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @Author: w
 * @Date: 2021/7/5 22:30
 * 线程活跃性
 * 活跃性分为：死锁、活锁和饥饿
 *
 * 定位死锁：检测死锁可以使用jconsole工具，或者使用jps定位进程id，再用jstack定位死锁
 */
@Slf4j
public class DeadLock {

    private static final Object LOCK_A = new Object();

    private static final Object LOCK_B = new Object();

    public static void main(String[] args) {
        deadLockVersion1();
    }

    /**
     * 死锁：有这样的情况：一个线程需要同时获取多把锁，这时就容易发生死锁
     * t1线程获得A对象锁，接下来想获取b对象的锁
     * t2线程获得b对象锁，接下来想获取a对象的锁
     */
    private static void deadLockVersion1() {

        // 线程a获取到a锁
        new Thread(() -> {
            System.out.println();
            synchronized (LOCK_A) {
                log.debug("lock a...");
                // 过了1秒后获取b锁
                try {
                    TimeUnit.SECONDS.sleep(1);
                    synchronized (LOCK_B) {
                       log.debug("我把锁都获取到了...");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"a").start();

        new Thread(() -> {
            synchronized (LOCK_B) {
                log.debug("lock b...");
                // 过了1秒后获取b锁
                try {
                    TimeUnit.SECONDS.sleep(2);
                    synchronized (LOCK_A) {
                        log.debug("我把锁都获取到了...");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"b").start();
    }


}
