package com.thread.reentrantLock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: w
 * @Date: 2021/6/27 9:55
 * 条件变量的使用案例
 *
 * 需求：
 *  小明在等外卖，小红在等快递；
 *  外卖到了需要唤醒小明；快递到了需要唤醒小红
 * 1：采用wait 和 notifyAll实现
 */
@Slf4j
public class ConditionUse {

    private static ReentrantLock lock = new ReentrantLock();

    // 外卖是否到了
    private static Boolean hasWaiMai = false;

    // 快递是否到了
    private static Boolean hasKuaiDi = false;

    // 锁
    private static final Object LOCK = new Object();

    // 外卖条件变量
    private static Condition waiMaiCondition = lock.newCondition();

    // 快递条件变量
    private static Condition kuaiDiCondition = lock.newCondition();

    public static void main(String[] args) {
        //version1();
        version2();
    }


    /**
     * 采用wait...notifyAll实现
     */
    private static void version1() {
        // 小明
        new Thread(() -> {
            synchronized (LOCK) {
                log.debug("外卖到了吗？好饿啊");
                while (!hasWaiMai) {
                    log.debug("外卖还没到，再等等吧...");
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (hasWaiMai) {
                    log.debug("**，我的外卖终于到了");
                }else {
                    log.debug("oh no，小爷肚腩的饿没了");
                }
            }
        },"小明").start();

        // 小红
        new Thread(() -> {
            synchronized (LOCK) {
                log.debug("快递还没到吗？好像戴上我的50克拉大钻戒啊...");
                while (!hasKuaiDi) {
                    log.debug("快递还没到，我还是先看两集电视吧...");
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (hasKuaiDi) {
                    log.debug("我的50克拉大钻戒终于到了啊");
                }else {
                    log.debug("哇，还要等多久啊...");
                }
            }
        },"小红").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 送快递线程
        new Thread(() -> {
            synchronized (LOCK) {
                log.debug("您的快递已送达，请注意查收...");
                // 唤醒全部线程
                LOCK.notifyAll();
                // 设置快递已到
                hasKuaiDi = true;
            }
        },"快递小哥").start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 送外卖线程
        new Thread(() -> {
            synchronized (LOCK) {
                log.debug("您的外卖已经到了，记得给个五星好评喔...");
                // 唤醒全部线程
                LOCK.notifyAll();
                // 设置外卖已经到了
                hasWaiMai = true;
            }
        },"外卖小哥").start();
    }


    /**
     * 采用condition条件变量唤醒
     */
    private static void version2() {

        // 小明
        new Thread(() -> {
            // 先获取锁
            lock.lock();
            try {
                log.debug("外卖到了吗？好饿啊");
                while (!hasWaiMai) {
                    log.debug("外卖还没到，再等等吧...");
                    // 等待
                    try {
                        waiMaiCondition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("**，我的外卖终于到了");
            }finally {
                lock.unlock();
            }
        },"小明").start();

        // 小红
        new Thread(() -> {
            // 获取锁
            lock.lock();
            try {
                log.debug("快递还没到吗？好像戴上我的50克拉大钻戒啊...");
                while (!hasKuaiDi) {
                    log.debug("快递还没到，我还是先看两集电视吧...");
                    try {
                        kuaiDiCondition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("我的50克拉大钻戒终于到了啊");
            }finally {
                lock.unlock();
            }
        },"小红").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 送快递线程
        new Thread(() -> {
            lock.lock();
            try {
                log.debug("您的快递已送达，请注意查收...");
                // 唤醒快递条件变量中全部线程
                kuaiDiCondition.signalAll();
                // 设置快递已到
                hasKuaiDi = true;
            }finally {
                lock.unlock();
            }
        },"快递小哥").start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 送外卖线程
        new Thread(() -> {
            lock.lock();
            try {
                log.debug("您的外卖已经到了，记得给个五星好评喔...");
                // 唤醒外卖条件变量中全部线程
                waiMaiCondition.signalAll();
                // 设置外卖已经到了
                hasWaiMai = true;
            }finally {
                lock.unlock();
            }
        },"外卖小哥").start();
    }
}
