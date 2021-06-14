package com.thread.createThread.thread.basic;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: w
 * @Date: 2021/6/12 11:18
 */
@Slf4j
public class ExtendThread2 {

    public static void main(String[] args) {
        new Thread(() -> {
            log.debug("running....");
        },"从线程").start();
        log.debug("running....");
    }
}
