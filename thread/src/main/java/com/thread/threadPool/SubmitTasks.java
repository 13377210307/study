package com.thread.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @Author: w
 * @Date: 2021/6/22 22:46
 * 提交任务
 */
@Slf4j
public class SubmitTasks {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        //executeMethod(pool);
        submitMethod(pool);
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
            log.debug("执行结果：{}",future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
