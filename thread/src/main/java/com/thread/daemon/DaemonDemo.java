package com.thread.daemon;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @Author: w
 * @Date: 2021/7/12 23:03
 * 通过守护线程实现监控功能
 * thread.setDaemon(true)必须在thread.start()之前设置，否则会跑出一个IllegalThreadStateException异常；就是不能把正在运行的常规线程设置为守护线程
 */
@Slf4j
public class DaemonDemo {

    public static void main(String[] args) {

        daemonThreadRun();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("running...");
    }

    private static void daemonThreadRun() {
        Thread thread = new Thread(() -> {
            while (true) {
                log.debug("daemonThread running...");
            }
        }, "daemon");

        thread.setDaemon(true);
        thread.start();
    }
}
