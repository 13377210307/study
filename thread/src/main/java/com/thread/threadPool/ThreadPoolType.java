package com.thread.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: w
 * @Date: 2021/6/22 22:01
 * 线程类型
 */
@Slf4j
public class ThreadPoolType {

    public static void main(String[] args) {
        //newFixedThreadPoolType();
        //newCachedThreadPoolType();
        newSingleThreadExecutorType();
    }

    /**
     * newFixedThreadPool
     * 创建三个任务，但最大线程数设置为2；这时会由线程1、2执行任务，任务3放入阻塞队列等待；然后再由线程1去执行任务；
     * 创建出来的线程即使执行完任务也不会主动销毁
     *
     * 若要设置名称，则需要实现线程工厂中的方法
     */
    private static void newFixedThreadPoolType() {
        ExecutorService pool = Executors.newFixedThreadPool(2, new ThreadFactory() {
            private AtomicInteger t = new AtomicInteger(1);
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r,"my_pool_" + t.getAndIncrement());
            }
        });

        pool.execute(() -> {
            log.debug("任务1...");
        });

        pool.execute(() -> {
            log.debug("任务2...");
        });

        pool.execute(() -> {
            log.debug("任务3...");
        });
    }

    /**
     * newCachedThreadPool
     * 只有当阻塞队列中的值在有线程取得时候才会将值放入阻塞队列
     */
    private static void newCachedThreadPoolType() {
        SynchronousQueue<Integer> integers = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                log.debug("putting {}",1);
                integers.put(1);
                log.debug("{} putted...",1);

                log.debug("putting {}",2);
                integers.put(2);
                log.debug("{} putted...",2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            try {
                log.debug("taking {}",1);
                integers.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2").start();

        new Thread(() -> {
            try {
                log.debug("taking {}",2);
                integers.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t3").start();
    }


    /**
     * newSingleThreadExecutor
     * 执行三个任务，中间某个任务出现异常
     */
    private static void newSingleThreadExecutorType() {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        pool.execute(() -> {
            log.debug("任务1...");
            int i = 1/0;
        });

        pool.execute(() -> {
            log.debug("任务2...");
        });

        pool.execute(() -> {
            log.debug("任务3...");
        });
    }
}
