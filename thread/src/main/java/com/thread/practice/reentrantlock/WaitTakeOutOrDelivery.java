package com.thread.practice.reentrantlock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: w
 * @Date: 2021/6/27 20:57
 * 等外卖或快递
 * 需求：
 * 小明等外卖在外卖没来的时候只能打游戏；小红等快递在快递没来的时候只能看电视
 * 实现：
 * 小明线程：在外卖没来的时候利用ReentrantLock的条件变量进行等待；当外卖小哥来的时候唤醒小明线程；小红线程类似
 */
@Slf4j
public class WaitTakeOutOrDelivery {

    private static ReentrantLock reentrantLock = new ReentrantLock();

    private static Boolean hasTakeOut = false;

    private static Boolean hasDelivery = false;

    private static Condition takeOutCondition = reentrantLock.newCondition();

    private static Condition deliveryCondition = reentrantLock.newCondition();

    public static void main(String[] args) {
        waitTakeOutOrDeliveryMethod();
    }

    /**
     * 使用await的时候必须先获取锁
     */
    private static void waitTakeOutOrDeliveryMethod() {
        // 小明线程
        new Thread(() -> {
            reentrantLock.lock();
            try {
               while (!hasTakeOut) {
                  log.debug("外卖还没到...还是先打打游戏吧...");
                   try {
                       takeOutCondition.await();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
               log.debug("外卖到了，可以吃饭了...");
            }finally {
                reentrantLock.unlock();
            }
        },"小明").start();

        // 小红线程
        new Thread(() -> {
            reentrantLock.lock();
            try {
                while (!hasDelivery) {
                    log.debug("快递还没到...还是先看看电视吧...");
                    try {
                        deliveryCondition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("快递到了，可以戴上我50克拉的钻戒了...");
            }finally {
                reentrantLock.unlock();
            }
        },"小红").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 快递小哥
        new Thread(() -> {
            reentrantLock.lock();
            try {
                log.debug("您的快递已经到了...请注意签收");
                // 唤醒小红
                deliveryCondition.signalAll();
                hasDelivery = true;
            }finally {
                reentrantLock.unlock();
            }
        },"快递小哥").start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 外卖小哥
        new Thread(() -> {
            reentrantLock.lock();
            try {
                log.debug("您的外卖已经到了..祝您用餐愉快");
                // 唤醒小明
                takeOutCondition.signalAll();
                hasTakeOut = true;
            }finally {
                reentrantLock.unlock();
            }
        },"外卖小哥").start();
    }
}
