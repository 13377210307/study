package com.thread.practice.methods;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @Author: w
 * @Date: 2021/7/16 12:18
 * 两阶段终止模式
 *                    while(true)
 *                        |
 *                        |
 *   -----------------------------------------------
 *       有没有被打断
 *   |               |
 *   是              否
 *   |               |
 *   料理后事       睡眠2秒-----------------------------有异常
 *   |               |                                  |
 *   结束循环        执行监控记录                    设置打断标志
 */
@Slf4j
public class TwoTerminationModel {

    // 监控器
    private static Thread monitor;

    public static void main(String[] args) {
        start();
        // 10s之后打断线程
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        interrupt();
    }

    // 开启监控
    private static void start() {
        monitor = new Thread(() -> {
            while (true) {
                // 判断线程是否被打断
                boolean interrupted = monitor.isInterrupted();
                if (interrupted) {
                    // 料理后事
                    log.debug("我被打断了...，需要料理后事");
                    // 退出循环
                    break;
                }
                // 未被打断，休眠1秒，继续进行监控；出现异常了也需要设置打断标记
                try {
                    log.debug("监控线程...");
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    monitor.interrupt();
                }
            }
        });
        monitor.start();
    }

    // 打断
    private static void interrupt() {
        monitor.interrupt();
    }
}
