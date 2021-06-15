package com.thread.methods;


import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Author: w
 * @Date: 2021/6/13 18:29
 * sleep：
 * 1：调用sleep会让当前线程从running进入到TimedWaiting状态
 * 2：其他线程可以使用interrupt方法打断正在休眠的线程，但会抛出异常
 * 3：休眠完成的线程并不一定会马上执行，需要获取cpu时间片
 * 4：建议使用TimeUnit的sleep代替Thread的sleep获取更好的可读性
 *
 * yield
 * 1：调用yield会让当前线程从running进行runnable状态，然后调度执行其他同优先级的线程。如果这时没有同优先级的线程，那么不能保证让当前线程暂停
 *
 *
 * 线程优先级
 * 如果cpu比较忙，那么高优先级的线程会获得更多的时间片，但cpu闲时，优先级几乎没用
 */
@Slf4j
public class SleepAndYield {

    public static void main(String[] args) {
        //threadSleep();
        interruptSleep();
    }

    /**
     * 新线程休眠2秒；主线程休眠1秒后获取新线程状态
     */
    private static void threadSleep() {
        log.debug("开始休眠...");
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("休眠完毕...");
        });
        log.debug("线程状态：{}",thread.getState());
        thread.start();
        // 主线程休眠
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("线程状态：{}",thread.getState());
    }

    // 新线程休眠2秒；主线程休眠1秒后打断休眠的新线程
    private static void interruptSleep() {
        Thread thread = new Thread(() -> {
            try {
                log.debug("sleep...");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                log.debug("wake up...");
                e.printStackTrace();
            }
        });
        thread.start();
        // 主线程休眠
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 打断休眠
        log.debug("interrupt...");
        thread.interrupt();
    }

}
