package com.thread.practice.communication;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: w
 * @Date: 2021/6/27 15:44
 * 循环打印
 * 线程1输出a5次；线程2输出b5次；线程3输出c5次；要求实现输出abcabcabcabcabc怎么实现
 */
public class LoopPrint {

    private static ReentrantLock reentrantLock = new ReentrantLock();

    private static Condition condition1 = reentrantLock.newCondition();

    private static Condition condition2 = reentrantLock.newCondition();

    private static Condition condition3 = reentrantLock.newCondition();

    public static void main(String[] args) {
        /*
        // 版本1
        SyncWaitNotify syncWaitNotify = new SyncWaitNotify(1, 5);
        new Thread(() -> {
            syncWaitNotify.print("a",2,1);
        },"t1").start();

        new Thread(() -> {
            syncWaitNotify.print("b",3,2);
        },"t2").start();

        new Thread(() -> {
            syncWaitNotify.print("c",1,3);
        },"t3").start();*/

        // 版本2
        SyncAwaitSign syncAwaitSign = new SyncAwaitSign(5);
        Condition condition1 = syncAwaitSign.newCondition();
        Condition condition2 = syncAwaitSign.newCondition();
        Condition condition3 = syncAwaitSign.newCondition();
        new Thread(() -> {
            syncAwaitSign.print("a", condition1, condition2);
        }, "t1").start();

        new Thread(() -> {
            syncAwaitSign.print("b", condition2, condition3);
        }, "t2").start();

        new Thread(() -> {
            syncAwaitSign.print("c", condition3, condition1);
        }, "t3").start();
        // 唤醒线程a
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        syncAwaitSign.lock();
        try {
            condition1.signal();
        } finally {
            syncAwaitSign.unlock();
        }

    }
}

/**
 * flag：哪个线程该打印了；
 * loopNumber：循环次数
 */
@Slf4j
class SyncWaitNotify {

    private int flag;

    private int loopNumber;


    public SyncWaitNotify(int flag, int loopNumber) {
        this.flag = flag;
        this.loopNumber = loopNumber;
    }

    /**
     * 采用wait...notify
     */
    public void print(String str, int nextFlag, int currentFlag) {
        for (int i = 0; i < loopNumber; i++) {
            synchronized (this) {
                while (currentFlag != flag) {
                    // 不是当前线程打印时，放入等待队列进行等待
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 打印
                log.debug(str);
                // 唤醒其他线程
                this.notifyAll();
                // 将打印线程设置为下一个打印线程
                this.flag = nextFlag;
            }
        }
    }

}

@Slf4j
class SyncAwaitSign extends ReentrantLock {

    private int loopNumber;

    public SyncAwaitSign(int loopNumber) {
        this.loopNumber = loopNumber;
    }

    public void print(String str, Condition currentCondition, Condition nextCondition) {
        for (int i = 0; i < loopNumber; i++) {
            // 加锁
            lock();
            try {
                // 当前线程等待
                try {
                    currentCondition.await();
                    // 打印
                    log.debug(str);
                    // 唤醒下一个线程
                    nextCondition.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                unlock();
            }
        }
    }
}
