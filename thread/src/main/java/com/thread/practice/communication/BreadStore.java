package com.thread.practice.communication;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * @Author: w
 * @Date: 2021/6/19 15:31
 * 面包商店
 */
@Slf4j
public class BreadStore {

    public static void main(String[] args) {
        BreadFactory breadFactory = new BreadFactory(2);
        // 三个生产者
        for (int i = 0; i < 3; i++) {
            Integer id = i;
            new Thread(() -> {
                breadFactory.createBread(new Bread(id,"面包"+id));
            },"生产者").start();
        }


        // 消费者
        new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Bread bread = breadFactory.consumeBread();
                log.debug("消费者消费...{}", bread);
            }
        },"消费者").start();
    }
}

/**
 * 面包工厂
 */
@Slf4j
class BreadFactory {

    // 面包箱
    private LinkedList<Bread> breadBox = new LinkedList<>();

    // 面包箱容量
    private int capcity;

    public BreadFactory(int capcity) {
        this.capcity = capcity;
    }

    // 生产面包
    public void createBread(Bread bread) {
        synchronized (breadBox) {
            while (breadBox.size() >= capcity) {
                // 生产面包数大于面包箱容量
                log.debug("生产面包数过多，暂停生产...");
                try {
                    breadBox.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            log.debug("正在生产面包：{}",bread);
            breadBox.addLast(bread);
            // 唤醒消费者消费
            breadBox.notifyAll();
        }
    }

    // 消费面包
    public Bread consumeBread() {
        synchronized (breadBox) {
            while (breadBox.isEmpty()) {
                log.debug("没有面包了，暂停售卖...");
                try {
                    breadBox.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            log.debug("售卖面包...");
            Bread bread = breadBox.removeFirst();
            // 唤醒生产者
            breadBox.notifyAll();
            return bread;
        }
    }
}


/**
 * 面包类
 */
@Data
class Bread {

    private int id;

    private String name;

    public Bread(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
