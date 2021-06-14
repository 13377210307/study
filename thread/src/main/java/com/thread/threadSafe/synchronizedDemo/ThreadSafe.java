package com.thread.threadSafe.synchronizedDemo;

/**
 * @Author: w
 * @Date: 2021/6/14 14:19
 * 线程安全问题
 * 线程1对一个静态变量先做5000次自增，另一个线程对该变量做5000次自减，最后结果为
 *
 * 对于i++；i--操作而言，实际会产生如下的jvm字节码指令
 * getstatic   i  // 获取静态变量i的值
 * iconst_1     // 准备常量1
 * iadd         // 自增
 * putstatic   i  // 将修改后的值存入静态变量i
 *
 *
 * 出现非0情况分析
 * 线程1做自增操作的时候先获取主存中的静态变量，然后进行自增操作；准备将结果写入主存的时候时间片使用完毕；
 * 线程2做自减操作获取到静态变量的值认为0，进行自减操作，变为-1；写入主存-1；
 * 线程1获取到时间片将结果写入主存1；导致结果不一致
 *
 * 通过synchronized加锁让临界区的操作只有一个线程可以执行；这样就能保证结果正确
 *
 * 分析：
 * 线程1执行到synchronized (LOCK) 时获取lock锁，此时，线程2也执行到synchronized (LOCK)；但由于lock被线程1持有，所以线程2被阻塞；
 * 即使线程1时间片使用完，但线程1还是持有锁，线程2就还是在阻塞状态，当下次线程1获取时间片执行完写入结果操作时释放锁并唤醒等待线程；线程二在获取锁对象后才能对变量进行操作。
 *
 *
 * 思考：
 * synchronized实际是用锁对象保证了临界区内代码的原子性，临界区内的代码对外是不分割的，不会被线程打断
 *
 * 1：如果把synchronized放在for循环外面，会产生什么结果
 * 放在for循环外意味着某个线程抢到锁对象后会直接执行5000次的自增或自减操作，然后下一个线程再进行操作
 * 2：synchronized的锁对象不同会怎样
 * 两个锁对象不同，还是有结果错误的情况
 * 3：只给一个线程加锁
 * 由于其中一个线程不加锁所以不会被阻塞，因此结果还是有误
 */
public class ThreadSafe {

    private static int count = 0;

    private static final Object LOCK = new Object();

    public static void main(String[] args) {
        /*Thread incr = incr();
        Thread decr = decr();
        incr.start();
        decr.start();*/
        Thread incrSafe = incrSafe();
        Thread decrSafe = decrSafe();
        incrSafe.start();
        decrSafe.start();
        // join是为了让自增自减操作执行完，不然主线程先执行始终为0
        try {
            //incr.join();
            //decr.join();
            incrSafe.join();
            decrSafe.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }

    // 自增运算（不安全）
    private static Thread incr() {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                count++;
            }
        }, "t1");
        return thread;
    }

    // 自减运算（不安全）
    private static Thread decr() {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                count--;
            }
        }, "t1");
        return thread;
    }

    // 自增运算（加锁）
    private static Thread incrSafe() {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                synchronized (LOCK) {
                    count++;
                }
            }
        }, "t1");
        return thread;
    }

    // 自减运算（加锁）
    private static Thread decrSafe() {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                synchronized (LOCK) {
                    count--;
                }
            }
        }, "t1");
        return thread;
    }
}
