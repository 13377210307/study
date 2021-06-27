package com.thread.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author: w
 * @Date: 2021/6/22 22:46
 * 提交任务
 */
@Slf4j
public class SubmitTasks {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        //executeMethod(pool);
        //submitMethod(pool);
        //submitAllTasks(pool);
        submitAnyTasks(pool);
    }

    // 执行任务
    private static void executeMethod(ExecutorService pool) {
        pool.execute(() -> {
            log.debug("execute方法...");
        });
    }

    // 提交任务task，用返回值Future获得任务执行结果
    private static void submitMethod(ExecutorService pool) {
        Future<String> future = pool.submit(() -> {
            TimeUnit.SECONDS.sleep(1);
            return "ok...";
        });
        try {
            log.debug("执行结果：{}", future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    // 提交tasks中所有任务：任务3打印begin比较晚是因为线程池只有2容量，第三个任务会放在队列中等待
    private static void submitAllTasks(ExecutorService pool) throws InterruptedException {
        List<Future<Object>> futures = pool.invokeAll(Arrays.asList(
                () -> {
                    log.debug("begin...");
                    TimeUnit.SECONDS.sleep(1);
                    return "1";
                },

                () -> {
                    log.debug("begin...");
                    TimeUnit.SECONDS.sleep(3);
                    return "2";
                },

                () -> {
                    log.debug("begin...");
                    TimeUnit.SECONDS.sleep(2);
                    return "3";
                }
        ));
        futures.forEach(future -> {
            log.debug("结果为：{}",future);
        });
    }

    // 提交tasks中所有任务，那个任务先成功执行完毕，返回此任务的执行结果，其他任务取消
    private static void submitAnyTasks(ExecutorService pool) throws ExecutionException, InterruptedException {
        Object result = pool.invokeAny(Arrays.asList(
                () -> {
                    log.debug("begin...");
                    TimeUnit.SECONDS.sleep(1);
                    return "1";
                },

                () -> {
                    log.debug("begin...");
                    TimeUnit.SECONDS.sleep(3);
                    return "2";
                },

                () -> {
                    log.debug("begin...");
                    TimeUnit.SECONDS.sleep(2);
                    return "3";
                }
        ));
        log.debug("结果为：{}",result);
    }

}
