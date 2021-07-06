package com.thread.synchronizedDome;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @Author: w
 * @Date: 2021/7/5 22:17
 * synchronized使用
 */
public class SynchronizedUse {

    public static void main(String[] args) {
        //version1();
        version2();
    }

    /**
     * 多把不相干的锁
     * 一间屋子有两个功能：睡觉、学习，互不相干
     * 现在线程1要学习，线程2要睡觉，但如果只用一间屋子（对象锁）的话，那么并发度很低
     * 解决办法是准备多个房间
     */
    private static void version1() {
        BigRoom bigRoom = new BigRoom();
        new Thread(bigRoom::sleep,"t1").start();
        new Thread(bigRoom::study,"t2").start();
    }

    /**
     * 通过多把锁增加锁的细粒度，但两个线程需要不占用同一资源、互不相干；
     * 好处：可以增加并发度
     * 坏处：如果一个线程需要同时获得多把锁，就容易造成死锁
     */
    private static void version2() {
        BigRoom bigRoom = new BigRoom();
        new Thread(bigRoom::sleep1,"t1").start();
        new Thread(bigRoom::study1,"t2").start();
    }
}

@Slf4j
class BigRoom {

    private final Object BED_ROOM = new Object();

    private final Object STUDY_ROOM = new Object();

    public void sleep() {
        synchronized (this) {
            log.debug("需要睡觉...");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void study() {
        synchronized (this) {
            log.debug("需要学习...");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void sleep1() {
        synchronized (BED_ROOM) {
            log.debug("需要睡觉...");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void study1() {
        synchronized (STUDY_ROOM) {
            log.debug("需要学习...");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
