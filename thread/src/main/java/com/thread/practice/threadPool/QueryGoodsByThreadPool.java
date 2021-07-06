package com.thread.practice.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author: w
 * @Date: 2021/6/25 8:59
 * 根据线程池查询商品
 * 查询商品时，我们需要查询到商品的基本信息、优惠信息、库存信息等，
 * 为了加快响应速度，我们可以采用线程池方式并行查询这三个信息
 */
@Slf4j
public class QueryGoodsByThreadPool {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        queryGoodDetail(pool);
        queryDiscountDetail(pool);
        queryStockDetail(pool);

    }

    // 查询商品信息
    private static void queryGoodDetail(ExecutorService pool) {
        pool.execute(() -> {
            log.debug("查询商品信息...");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("已获取商品信息...");
        });
    }

    // 查询优惠信息
    private static void queryDiscountDetail(ExecutorService pool) {
        pool.execute(() -> {
            log.debug("查询商品优惠信息...");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("已获取商品优惠信息...");
        });
    }

    // 查询库存信息
    private static void queryStockDetail(ExecutorService pool) {
        pool.execute(() -> {
            log.debug("查询商品库存信息...");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("已经获取到商品库存信息...");
        });
    }

}
