package com.thread.aqs.cyclicBarrier;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author: w
 * @Date: 2021/7/4 15:29
 */
@Slf4j
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        //version1();
        version2();
    }

    /**
     * 两个任务完成后主线程打印
     */
    private static void version1() {
        log.debug("begin....");
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> {
            log.debug("task1、task2 is finished....");
        });

        executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                cyclicBarrier.await(); // 等同于countdownLatch中的countdown
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                cyclicBarrier.await(); // 等同于countdownLatch中的countdown
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown();
    }

    /**
     * 循环两次任务后主线程进行打印：
     * 注意：线程池线程数与cyclicBarrier的数目保持一致：若线程池中线程数大于cyclicBarrier的数目，有可能导致某个线程执行多遍某个任务然后其他线程执行1遍另一个任务
     */
    private static void version2() {
        log.debug("begin....");
        // 创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> {
            log.debug("task1、task2 is finished....");
        });

        for (int i = 0; i < 2; i++) {
            executorService.submit(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            executorService.submit(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }
}
