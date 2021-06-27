package com.thread.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author: w
 * @Date: 2021/6/23 22:57
 */
@Slf4j
public class ShutdownMethod {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        //shutdown(pool);
        shutdownNow(pool);
    }

    /**
     * 1、2、3可以执行，因为在shutdown之前进行提交的；4不能会抛出异常
     * 他不会阻塞其他线程
     */
    private static void shutdown(ExecutorService pool) {
        pool.submit(() -> {
            log.debug("task 1 running...");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("task 1 finish...");
            return 1;
        });

        pool.submit(() -> {
            log.debug("task 2 running...");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("task 2 finish...");
            return 2;
        });

        pool.submit(() -> {
            log.debug("task 3 running...");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("task 3 finish...");
            return 3;
        });

        log.debug("shutdown");
        pool.shutdown();
        log.debug("不阻塞....");

        pool.submit(() -> {
            log.debug("task 4 running...");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("task 4 finish...");
            return 4;
        });


    }

    private static void shutdownNow(ExecutorService pool) {
        pool.submit(() -> {
            log.debug("task 1 running...");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("task 1 finish...");
            return 1;
        });

        pool.submit(() -> {
            log.debug("task 2 running...");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("task 2 finish...");
            return 2;
        });

        pool.submit(() -> {
            log.debug("task 3 running...");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("task 3 finish...");
            return 3;
        });

        log.debug("shutdownNow");
        List<Runnable> runnables = pool.shutdownNow();
        log.debug("结果为：{}",runnables);
    }
}
