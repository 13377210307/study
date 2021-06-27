package com.thread.reentrantLock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: w
 * @Date: 2021/6/24 22:29
 */
@Slf4j
public class ReentrantLockUse {

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        // 可重入
        //reentrantMethod();

        // 可打断
        /*Thread thread = interruptMethod();
        // 主线程先获取锁，让t1线程阻塞
        lock.lock();
        thread.start();
        // 主线程打断t1线程
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();*/

        // 锁超时
        Thread thread = lockWait();
        // 主线程先获取锁
        log.debug("获取锁...");
        lock.lock();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 主线程释放锁
        log.debug("释放锁...");
        lock.unlock();
        thread.start();
    }

    /**
     * reentrantLock可重入
     * 此方法在没释放锁的情况下会调用m1，m1的执行也需要该锁，而m1会调用m2，m2的执行也需要该锁
     * 最后都能成功打印，说明reentrantLock是可重入的
     */
    private static void reentrantMethod() {
        lock.lock();
        try {
            log.debug("enter main...");
            m1();
        }finally {
            lock.unlock();
        }
    }

    private static void m1() {
        lock.lock();
        try {
            log.debug("enter m1...");
            m2();
        }finally {
            lock.unlock();
        }
    }

    private static void m2() {
        lock.lock();
        try {
            log.debug("enter m2...");
        }finally {
            lock.unlock();
        }
    }

    /**
     * reentrantLock可打断特性
     * 该特性可以防止线程无意义的等待，避免死等
     */
    private static Thread interruptMethod() {
        Thread thread = new Thread(() -> {
            try {
                // 如果没有竞争那么此方法就会获取lock对象
                // 如果有竞争就进入阻塞队列，可以被其他线程用interrupt方法打断
                log.debug("尝试获取锁...");
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
                log.debug("没有获取到锁...");
                return;
            }
            try {
                log.debug("获取到锁...");
            }finally {
                lock.unlock();
            }
        }, "t1");
        return thread;
    }

    /**
     * 锁超时：在获取锁的过程中，如果其他线程一直没有释放锁，该线程就会放弃等待，属于主动避免打断；若主线程一直未调用unlock方法，t1线程就一直获取不到锁
     */
    private static Thread lockWait() {
        Thread thread = new Thread(() -> {
            // 尝试去获取锁；
            log.debug("尝试获取锁");
            try {
                // 尝试等待一秒获取锁
                if (!lock.tryLock(2,TimeUnit.SECONDS)) {
                    log.debug("无法获取锁...");
                    return;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                log.debug("获取到锁...");
            } finally {
                lock.unlock();
            }
        },"t1");
        return thread;
    }
}
