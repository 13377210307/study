package com.thread.state;

import java.util.concurrent.TimeUnit;

/**
 * @Author: w
 * @Date: 2021/6/14 10:10
 * 线程状态
 */
public class ThreadState {

    public static void main(String[] args) {
        newState();
        runnableState();
        terminatedState();
        timedWaitingState();
    }

    // 新建状态：未调用start方法
    private static void newState() {
        Thread thread = new Thread(() -> {
        }, "new");
        System.out.println("线程状态：" + thread.getState());
    }

    // 就绪状态
    private static void runnableState() {
        Thread thread = new Thread(() -> {
        }, "runnable");
        thread.start();
        System.out.println("线程状态：" + thread.getState());
    }

    // TERMINATED状态（终止）
    private static void terminatedState() {
        Thread thread = new Thread(() -> {
        }, "terminated");
        thread.start();
        // 主线程休眠
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程状态：" + thread.getState());
    }

    // TIMED_WAITING  timedWaiting：有时限的等待
    private static void timedWaitingState() {
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "timedWaiting");
        thread.start();
        // 主线程休眠
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程状态：" + thread.getState());
    }

    // BLOCKED
    private static void blockedState() {
        Thread thread = new Thread(() -> {
            synchronized (ThreadState.class) {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "blocked");
        thread.start();
        // 主线程休眠
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程状态：" + thread.getState());
    }



}
