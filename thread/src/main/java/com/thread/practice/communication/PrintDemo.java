package com.thread.practice.communication;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: w
 * @Date: 2021/6/27 10:47
 * <p>
 * 打印案例
 * 同步模式之顺序控制
 * <p>
 * 1：固定运行顺序：先打印2后打印1
 */
@Slf4j
public class PrintDemo {

    private static final Object LOCK = new Object();

    private static ReentrantLock lock = new ReentrantLock();

    private static Condition print2Condition = lock.newCondition();

    // 是否打印过2了
    private static Boolean print2 = false;


    public static void main(String[] args) {
        //version1();
        //version2();
        version3();
    }

    /**
     * wait...notify版本
     */
    private static void version1() {
        new Thread(() -> {
            synchronized (LOCK) {
                while (!print2) {
                    try {
                        // 等待
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("1...");
            }
        }, "打印机1打印").start();

        new Thread(() -> {
            synchronized (LOCK) {
                log.debug("2...");
                // 将打印2设置成真，并唤醒打印机1
                LOCK.notifyAll();
                print2 = true;
            }
        }, "打印机2打印").start();
    }

    /**
     * park...unpark方法
     */
    private static void version2() {
        Thread thread1 = new Thread(() -> {
            LockSupport.park();
            log.debug("1...");
        }, "线程1");
        thread1.start();

        new Thread(() -> {
            log.debug("2...");
            LockSupport.unpark(thread1);
        },"线程2").start();
    }

    /**
     * await...signAll版
     */
    private static void version3() {
        new Thread(() -> {
            lock.lock();
            try {
                while (!print2) {
                    try {
                        print2Condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("1...");
            }finally {
                lock.unlock();
            }
        },"t1").start();

        new Thread(() -> {
            lock.lock();
            try {
                log.debug("2...");
                print2Condition.signalAll();
                print2 = true;
            }finally {
                lock.unlock();
            }
        },"t2").start();
    }
}
