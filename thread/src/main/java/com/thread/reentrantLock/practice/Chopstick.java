package com.thread.reentrantLock.practice;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: w
 * @Date: 2021/6/26 15:54
 * 筷子类
 */
public class Chopstick extends ReentrantLock {

    private String name;

    public Chopstick(String name) {
        this.name = name;
    }
}
