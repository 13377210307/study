package com.thread.aqs.countdownLatch;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @Author: w
 * @Date: 2021/7/3 12:00
 * countdownLatch使用
 */
@Slf4j
public class CountdownLatchDemo {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);

        //version1(latch);

        //version2(latch);

        //version3(latch);

        version4(latch);
    }

    /**
     * 创建三个线程。等三个线程运行完之后主线程进行打印
     */
    private static void version1(CountDownLatch latch) {
        new Thread(() -> {
            log.debug("线程1开始执行...");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
        },"t1").start();

        new Thread(() -> {
            log.debug("线程2开始执行...");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
        },"t2").start();

        new Thread(() -> {
            log.debug("线程3开始执行...");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
        },"t3").start();

        log.debug("主线程waiting....");
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("主线程执行完毕...");
    }

    /**
     * 使用线程池实现：创建线程池容量为4，前3个任务进行查询，最后一个任务进行汇总
     */
    private static void version2(CountDownLatch latch) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(() -> {
            log.debug("begin...");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
            log.debug("end....{}", latch.getCount());
        });

        executorService.submit(() -> {
            log.debug("begin...");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
            log.debug("end....{}", latch.getCount());
        });

        executorService.submit(() -> {
            log.debug("begin...");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
            log.debug("end....{}", latch.getCount());
        });

        executorService.submit(() -> {
            try {
                log.debug("waiting...");
                latch.await();
                log.debug("waiting end....");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdown();

    }

    /**
     * 采用线程池实现等待多线程准备完毕
     * 10名玩家进入游戏，只有最后一名玩家游戏加载完毕才可以开始游戏
     */
    private static void version3(CountDownLatch latch) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Random random = new Random();
        String[] all = new String[10];
        for (int j = 0; j < 10; j++) {
            Integer k = j;
            executorService.submit(() -> {
                for (int i = 0; i <= 100; i++) {
                    try {
                        Thread.sleep(random.nextInt(100));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    all[k] = i + "%";
                    System.out.print("\r" + Arrays.toString(all));
                }
                latch.countDown();
            });
        }
        try {
            latch.await();
            System.out.println("\n开始游戏...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }

    /**
     * 查询一个商品信息
     * 采用多个服务方式：
     * 服务一：查询订单信息
     * 服务二：查询商品信息
     * 服务三：查询物流信息
     *
     * 由于此次有返回结果，所以使用future比较合适
     */
    private static void version4(CountDownLatch latch) {
        log.debug("开始查询...");
        //ExecutorService executorService = Executors.newFixedThreadPool(4);

        ExecutorService executorService = Executors.newCachedThreadPool();
        //Map<String,Map<String,Object>> productMap = new HashMap<>();

        // 查询订单信息
        Future<Map<String,Object>> f1 = executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            HashMap<String, Object> map = new HashMap<>();
            map.put("1","20210704111457");
            /*productMap.put("订单信息",map);
            latch.countDown();*/
            return map;
        });

        // 查询商品信息
        Future<Map<String,Object>> f2 = executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            HashMap<String, Object> map = new HashMap<>();
            map.put("小米11","星空蓝：8+256G版");
            /*productMap.put("商品信息",map);
            latch.countDown();*/
            return map;
        });

        // 查询物流信息
        Future<Map<String,Object>> f3 = executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            HashMap<String, Object> map = new HashMap<>();
            map.put("京东快递","以达到派送地，快递员刘**正在为您派送，请留意电话...");
            /*productMap.put("物流信息",map);
            latch.countDown();*/
            return map;
        });

        executorService.submit(() -> {
                //log.debug("您的订单信息为："+productMap);
                try {
                    log.debug("您的订单信息为："+ f1.get());
                    log.debug("您的商品信息为："+ f2.get());
                    log.debug("您的物流信息为："+ f3.get());
                } catch (Exception e) {
                    e.printStackTrace();
                }
        });

        executorService.shutdown();
    }

}
