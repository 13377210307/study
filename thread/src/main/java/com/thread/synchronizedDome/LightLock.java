package com.thread.synchronizedDome;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: w
 * @Date: 2021/7/10 20:35
 * 轻量级锁
 */
@Slf4j
public class LightLock {

    private final static Object LOCK = new Object();

    public static void main(String[] args) {
        method1();
    }

    /**
     * 两个线程使用锁的时间是错开的，不存在锁竞争情况：这时会优先使用轻量级锁
     * 线程1去调线程2
     *
     * 过程：
     * 1：创建锁记录对象，每个线程的栈帧都会包含一个锁记录的结构，内部可以存储锁定对象的mark word
     * 2：让锁记录中对象引用指向锁对象，并尝试用cas替换对象的mark word，将mark word的值存入锁记录
     * 3：如果cas替换成功，对象头中存储锁记录地址和状态00，表示由该线程给对象加锁
     * 4：如果cas失败，有两种情况
     * （1）如果是其他线程已经持有了该对象的轻量级，这时表明有竞争，进入锁膨胀
     * （2）如果是自己执行了synchronized锁重入，那么再添加一条lock record作为重入的计数
     * 5：当退出synchronized代码块时，如果有取值为null的所记录，表示有重入，这时重置锁记录，表示重入计数减一
     * 6：当退出synchronized代码块锁记录的值不为null，这时使用cas将mark word的值恢复给对象头
     * （1）成功，则解锁成功
     * （2）失败，说明轻量级锁进行了锁膨胀或已经升级为重量级锁，进入重量级锁解锁流程
     */
    private static void method1() {

        new Thread(() -> {
            synchronized (LOCK) {
                log.debug("method1 get LOCK...");
                method2();
            }
        }).start();

    }

    private static void method2() {
        new Thread(() -> {
            synchronized (LOCK) {
                log.debug("method2 get LOCK ...");
            }
        }).start();
    }
}
