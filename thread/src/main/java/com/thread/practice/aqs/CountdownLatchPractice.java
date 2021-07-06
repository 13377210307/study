package com.thread.practice.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @Author: w
 * @Date: 2021/7/5 8:34
 *
 * 案例一：采用countdownLatch实现一个线程等待多个线程
 */
@Slf4j
public class CountdownLatchPractice {

    public static void main(String[] args) {
        version1();
    }

    /**
     * 案例一：获取订单信息
     * 创建线程池，
     * 线程1：查询订单信息
     * 线程2：查询商品信息
     * 线程3：查询物流信息
     * 主线程汇总整个订单信息
     */
    private static void version1() {
        log.debug("查询开始...");
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService executorService = Executors.newCachedThreadPool();

        // 多线程对一个map进行操作，采用concurrentHashMap
        Map<String,Object> prodMap = new ConcurrentHashMap<>();

        // 查询订单信息
        executorService.submit(() -> {
            log.debug("正在查询订单信息...");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Map<String,Object> orderMap = new HashMap<>();
            orderMap.put("1","20210705084753");
            prodMap.put("订单信息",orderMap);
            latch.countDown();
        });

        // 查询商品信息
        executorService.submit(() -> {
            log.debug("正在查询商品信息...");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Map<String,Object> proMap = new HashMap<>();
            proMap.put("1","小米11：星空蓝：8+256版本");
            prodMap.put("商品信息",proMap);
            latch.countDown();
        });

        // 查询物流信息
        executorService.submit(() -> {
            log.debug("正在查询物流信息...");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Map<String,Object> map = new HashMap<>();
            map.put("1","快递员刘**正在为您派送，请留意您的电话...");
            prodMap.put("物流信息",map);
            latch.countDown();
        });

        executorService.shutdown();

        // 汇总
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("您查询的商品信息为：" + prodMap);
    }
}
