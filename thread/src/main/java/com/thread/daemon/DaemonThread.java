package com.thread.daemon;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @Author: w
 * @Date: 2021/6/14 9:44
 * 守护线程
 *
 */
@Slf4j
public class DaemonThread {

    public static void main(String[] args) {
        noDaemonThreadDemo();
        //daemonThreadDemo();
    }

    /**
     * 不设置守护线程的情况，在主线程运行完之后，新线程依旧运行
     */
    private static void noDaemonThreadDemo() {
        Thread daemon = new Thread(() -> {
            while(true) {
                if(Thread.currentThread().isInterrupted()) {
                    break;
                }
                log.debug("运行中....");
            }
            log.debug("运行结束...");
        },"daemon");
        daemon.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("运行结束...");
    }

    /**
     * 将新线程设置为守护线程，主线程作为非守护线程，运行完了，守护线程也会强制结束
     */
    private static void daemonThreadDemo() {
        Thread daemon = new Thread(() -> {
            while(true) {
                if(Thread.currentThread().isInterrupted()) {
                    break;
                }
                log.debug("运行中....");
            }
            log.debug("运行结束...");
        },"daemon");
        // 设置该线程为守护线程
        daemon.setDaemon(true);
        daemon.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("运行结束...");
    }
}
