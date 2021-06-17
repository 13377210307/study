package com.thread.communication;

import lombok.extern.slf4j.Slf4j;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @Author: w
 * @Date: 2021/6/16 22:27
 */
@Slf4j
public class CorrectPosture {

    private static boolean hasDrawing = false; // 是否有图纸

    private static final Object PROJECT = new Object(); // 项目

    private static boolean hasKuaiDi = false; // 快递是否到了

    private static boolean hasWaiMai = false;  // 外卖是否到了

    public static void main(String[] args) {
        //version1();
        //version2();
        //version3();
        version4();
    }

    /**
     * 版本一：
     * 需求：
     * 工地上有五个普通员工和一个工程师；工程师需要拿到图纸才能进行干活，而五个员工并不需要图纸也可以干活
     * 实现：
     * 创建一个工程师线程，此线程首先会先判断图纸有没有，没有就干不了活（休眠）
     * 创建五个普通员工线程，这些线程不需要什么条件就能干活
     * 创建一个送图纸线程，图纸到了，更改图纸是否有状态
     *
     * 存在问题：
     * 1：工程师线程有固定休眠时间（2秒），但图纸在1秒后就送到了，所以会多等一秒：解决：可以在送图纸线程中使用interrupt来打断工程师的休眠；
     * 2：其他普通员工线程只有等到工程师线程释放锁对象才能进行干活
     */
    private static void version1() {
        // 工程师线程
       Thread engineeThread =  new Thread(() -> {
            synchronized (PROJECT) {
                log.debug("图纸到了吗？【{}】",hasDrawing);
                if (!hasDrawing) {
                    log.debug("图纸没到，我这干不了活啊，那我再等等");
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("图纸到了吗？【{}】",hasDrawing);
                if (hasDrawing) {
                    log.debug("图纸到了，可以干活了");
                }
            }
        },"工程师");
       engineeThread.start();
        // 普通员工线程
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                synchronized (PROJECT) {
                    log.debug("兄弟们，开始干活了");
                }
            },"普通员工").start();
        }
        // 休眠一秒送图纸
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 送图纸线程
        new Thread(() -> {
           hasDrawing = true;
           // 打断工程师线程
            engineeThread.interrupt();
           log.debug("图纸给您送来了");
        }).start();
    }

    /**
     * 采用wait-notify方式解决
     * 改进：
     * 1：普通员工线程也可以进行
     * 2：图纸来了就可以通知工程师线程
     * 存在问题：
     * 1：notify是随机唤醒的，万一其他线程也wait住了，可能唤醒不了工程师线程
     */
    private static void version2() {
        // 工程师线程
        new Thread(() -> {
            synchronized (PROJECT) {
                log.debug("有图纸吗？：{}",hasDrawing);
                if (!hasDrawing) {
                    log.debug("没图纸干不了活，还是歇会吧");
                    try {
                        // 等图纸
                        PROJECT.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("有图纸吗？：{}",hasDrawing);
                if (hasDrawing) {
                    log.debug("图纸来了，可以干活了");
                }
            }
        },"工程师").start();

        // 普通员工线程
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                synchronized (PROJECT) {
                    log.debug("兄弟们开始干活了...");
                }
            },"普通员工").start();
        }

        // 休眠一秒
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 送图纸线程
        new Thread(() -> {
            synchronized (PROJECT) {
                // 更改变量
                hasDrawing = true;
                log.debug("图纸送到了...");
                // 通知工程师图纸已送到
                PROJECT.notify();
            }
        },"送图纸").start();
    }

    /**
     * 虚假唤醒：可以通过notifyAll唤醒所有线程
     */
    private static void version3() {
        new Thread(() -> {
            synchronized (PROJECT) {
                log.debug("快递到了吗？{}", hasKuaiDi);
                if (!hasKuaiDi) {
                    log.debug("快递还没到，我还是再等等吧...");
                    try {
                        PROJECT.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (hasKuaiDi) {
                    log.debug("快递到了，我去拿快递...");
                }else {
                    log.debug("快递还是没到..");
                }
            }
        },"快递").start();

        new Thread(() -> {
            synchronized (PROJECT) {
                log.debug("外卖到了吗？{}", hasWaiMai);
                if (!hasWaiMai) {
                    log.debug("外卖还没到，我还是再等等吧...");
                    try {
                        PROJECT.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (hasWaiMai) {
                    log.debug("外卖到了，我去拿外卖...");
                }else {
                    log.debug("外卖还是没到..");
                }
            }
        },"外卖").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 外卖小哥
        new Thread(() -> {
            synchronized (PROJECT) {
                log.debug("您的外卖已送达...");
                hasWaiMai = true;
                PROJECT.notifyAll();
            }
        },"外卖小哥").start();
    }

    /**
     * 解决虚假唤醒：由于外卖线程也会唤醒快递线程，所以我们采用while替代if，让快递线程wait住，直到快递小哥通知快递到了
     */
    private static void version4() {
        new Thread(() -> {
            synchronized (PROJECT) {
                log.debug("快递到了吗？{}", hasKuaiDi);
                while (!hasKuaiDi) {
                    log.debug("快递还没到，我还是再等等吧...");
                    try {
                        PROJECT.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (hasKuaiDi) {
                    log.debug("快递到了，我去拿快递...");
                }else {
                    log.debug("快递还是没到..");
                }
            }
        },"快递").start();

        new Thread(() -> {
            synchronized (PROJECT) {
                log.debug("外卖到了吗？{}", hasWaiMai);
                while (!hasWaiMai) {
                    log.debug("外卖还没到，我还是再等等吧...");
                    try {
                        PROJECT.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (hasWaiMai) {
                    log.debug("外卖到了，我去拿外卖...");
                }else {
                    log.debug("外卖还是没到..");
                }
            }
        },"外卖").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 外卖小哥
        new Thread(() -> {
            synchronized (PROJECT) {
                log.debug("您的外卖已送达...");
                hasWaiMai = true;
                PROJECT.notifyAll();
            }
        },"外卖小哥").start();
    }
}
