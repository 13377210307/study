package com.thread.practice.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @Author: w
 * @Date: 2021/7/5 14:26
 */
@Slf4j
public class Test {

    public static void main(String[] args) {
        test();
    }

    private static void test() {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<String> result = executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "success";
        });

        executorService.shutdown();

        try {
            log.debug(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
