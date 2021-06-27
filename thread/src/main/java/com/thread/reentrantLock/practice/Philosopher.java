package com.thread.reentrantLock.practice;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @Author: w
 * @Date: 2021/6/26 15:54
 * 哲学家
 */
@Slf4j
public class Philosopher extends Thread{

    private Chopstick left;

    private Chopstick right;

    public Philosopher(String name, Chopstick left, Chopstick right) {
        super(name);
        this.left = left;
        this.right = right;
    }

    @Override
    public void run() {
        while (true) {
            // 将筷子作为锁对象，尝试去获取锁，获取不到就释放之前锁对象
            boolean hasLeft = left.tryLock();
            if (hasLeft) {
                try {
                    // 获取右手筷子
                    boolean hasRight = right.tryLock();
                    if (hasRight) {
                        try {
                            eat();
                        }finally {
                            right.unlock();
                        }
                    }
                }finally {
                    // 释放锁
                    left.unlock();
                }
            }
        }
    }

    // 吃饭
    private void eat() {
        log.debug("正在吃饭....");
        try {
            // 思考
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
