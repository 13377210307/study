package com.thread.daemon;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author: w
 * @Date: 2021/7/15 18:19
 */
@Slf4j
public class DaemonDemo1 {

    public static void main(String[] args) {
       //daemon1();
       // test1();
        daemon2();
    }

    /**
     * 线程2运行11次；线程0、线程1各运行6次；守护线程会运行大于10次（不会在所有线程执行完之后就马上销毁
     */
    private static void daemon1() {
        Integer count = 3;
        while (count-- > 0) {
            if (count == 2) {
                Thread thread = new Thread(() -> {
                    Thread daemonThread = new Thread(() -> {
                        int countOfDemo = 0;
                        while (true) {
                            log.debug("守护线程活着，检测次数 {}", ++countOfDemo);
                            try {
                                TimeUnit.SECONDS.sleep(1);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }, "守护线程");
                    daemonThread.setDaemon(true);
                    daemonThread.start();
                    int counts = 10;
                    while (counts-- >= 0) {
                        log.debug("{} is alive", Thread.currentThread().getName());
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }, "线程" + count);
                thread.start();
            } else {
                Thread thread = new Thread(() -> {
                    int counts = 5;
                    while (counts-- >= 0) {
                        log.debug("{} is alive", Thread.currentThread().getName());
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }, "线程" + count);
                thread.start();
            }
        }
    }

    private static void daemon2() {
        // 初始到期时间为当前时间后的30s
        AtomicReference<DateTime> expTime = new AtomicReference<>(DateUtil.offsetSecond(new Date(), 20));

        new Thread(() -> {
            Integer count = 1;
            while (true) {
                Date newExpDate = expTime.get().toJdkDate();
                Date now = new Date();
                // 相差5秒的时候开始进行延长
                long betweenSecond = DateUtil.between(newExpDate, now, DateUnit.SECOND);
                if (betweenSecond <= 5) {
                    expTime.set(DateUtil.offsetSecond(new Date(), 20 * (count++)));
                }
                log.debug("该线程会在{}过期", expTime);
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"普通线程").start();

        Thread thread = new Thread(() -> {
            while (true) {
                log.debug("{} is alive", Thread.currentThread().getName());
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "守护线程");

        thread.setDaemon(true);
        thread.start();


    }

    /**
     * 延长过期时间
     * 延长的时间为固定30秒*已经延长的次数
     */
    private static void expandExpTime(DateTime expTime, Integer count) {
        Date newExpDate = expTime.toJdkDate();
        Date now = new Date();
        // 相差5秒的时候开始进行延长
        long betweenSecond = DateUtil.between(newExpDate, now, DateUnit.SECOND);
        if (betweenSecond <= 5) {
            expTime = DateUtil.offsetSecond(new Date(), 30 * count);
            count ++;
        }
    }

}
