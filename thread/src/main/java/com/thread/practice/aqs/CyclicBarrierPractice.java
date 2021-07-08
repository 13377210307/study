package com.thread.practice.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: w
 * @Date: 2021/7/8 8:56
 * 循环栅栏练习：几个选手赛跑等到选手准备好了就开始比赛
 */
@Slf4j
public class CyclicBarrierPractice {

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        commonRunning(cyclicBarrier,pool,"一号");
        commonRunning(cyclicBarrier,pool,"二号");
        commonRunning(cyclicBarrier,pool,"三号");
        pool.shutdown();
    }

    private static void commonRunning(CyclicBarrier cyclicBarrier,ExecutorService pool,String name) {
        Random random = new Random();
        pool.submit(() -> {
            try {
                Thread.sleep(random.nextInt(1000) * 3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("{}选手已就位",name);
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            log.debug("{}选手起跑",name);
        });
    }
}
