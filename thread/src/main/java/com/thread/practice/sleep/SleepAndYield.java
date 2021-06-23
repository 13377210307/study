package com.thread.practice.sleep;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @Author: w
 * @Date: 2021/6/22 8:40
 * 线程休眠与暂停
 * 线程休眠（sleep）
 * 1：线程休眠会由running状态变成timedWaiting状态
 * 2：若有新线程打断正在休眠的线程则会抛出异常并且会将打断标记重置
 * 3：休眠完毕的线程不一定马上变成running装态，而是需要等待cpu分配时间片
 *
 * 线程暂停（yield）
 * 调用yield会让当前线程从running进行runnable状态，然后调度执行其他同优先级的线程。如果这时没有同优先级的线程，那么不能保证让当前线程暂停
 */
@Slf4j
public class SleepAndYield {

    public static void main(String[] args) {
        Thread thread = sleepMethod();
        // 获取休眠线程状态
        log.debug("打断之前休眠线程状态：{}",thread.getState());
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 打断休眠线程
        thread.interrupt();
        // 获取休眠线程状态
        log.debug("打断之后休眠线程状态：{}",thread.getState());

    }

    /**
     * 休眠方法
     */
    private static Thread sleepMethod() {
        Thread thread = new Thread(() -> {
            log.debug("线程开始休眠...");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("线程休眠结束...");
        }, "sleep");
        thread.start();
        return thread;
    }

    /**
     * 暂停方法
     */
    private static Thread yieldMethod() {
        Thread thread = new Thread(() -> {
            log.debug("线程开始暂停...");
            Thread.yield();
        }, "yield");
        return thread;
    }
}
