package com.thread.practice.methods;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: w
 * @Date: 2021/6/21 8:34
 * join练习
 * 哪个线程调用join方法，其他线程就得等待这个线程执行完毕
 */
@Slf4j
public class JoinPractice {

    // 采用AtomicInteger保证变量原子性
    private static AtomicInteger r1 = new AtomicInteger(0);

    public static void main(String[] args) {
        demo1();
    }

    /**
     * t1线程执行需要2秒，t2线程执行只需要1秒，但t2线程执行依赖于t1线程的结果；
     * 若采用串行方法的话，需要耗费3秒，但使用并行的话就只要2秒
     * 注：如果需要对t1线程的值进行修改的线程只有一个的话就可以不用保证变量原子性
     */
    public static void demo1() {

        // t1线程
        Thread thread = new Thread(() -> {
            log.debug("t1线程开始执行...");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            r1.getAndAdd(2);
            log.debug("t1线程执行完毕...");
        }, "t1");

        /**
         * t2线程；
         * 执行结果需要1秒，但是需要t1的执行结果，对于t2来说，它执行过程并不需要
         */
        Thread thread1 = new Thread(() -> {
            log.debug("t2线程开始执行...");
            try {
                TimeUnit.SECONDS.sleep(1);
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            r1.getAndAdd(-1);
            log.debug("t2线程执行完毕...");
        }, "t2");
        thread.start();
        thread1.start();

        try {
            // 主线程等待t2执行完毕
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.debug("r1的结果为：{}", r1);
    }
}
