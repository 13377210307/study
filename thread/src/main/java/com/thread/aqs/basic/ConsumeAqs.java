package com.thread.aqs.basic;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Author: w
 * @Date: 2021/6/30 22:20
 * 自定义aqs
 */
@Slf4j
public class ConsumeAqs {


    /**
     * 线程1先获取到锁，休眠1秒，线程2由于线程休眠获取不到锁进入阻塞队列，1秒后线程1释放锁，线程2获取到锁
     * @param args
     */
    public static void main(String[] args) {
        MyLock myLock = new MyLock();

        new Thread(() -> {
            myLock.lock();
            try {
                log.debug("locking....");
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }finally {
                log.debug("unlocking....");
                myLock.unlock();
            }
        },"线程1").start();

        new Thread(() -> {
            myLock.lock();
            try {
                log.debug("locking....");
            }finally {
                log.debug("unlocking....");
                myLock.unlock();
            }
        },"线程2").start();


    }


}

// 自定已锁（不可重入锁）
@Slf4j
class MyLock implements Lock {

    // 同步器类（独占锁）
    class MySync extends AbstractQueuedSynchronizer {

        // 加锁
        @Override
        protected boolean tryAcquire(int arg) {
            // 需要通过compareAndSet去获取锁，因为可能有多个线程去竞争这个锁对象；通过cas保证修改是原子性操作
            if (compareAndSetState(0,1)) {
                log.debug("获取到锁...");
                // 加上了锁，设置owner为当前线程；相当于获取到了monitor对象
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        /**
         * 释放锁
         * 注意顺序：将设置状态放在后面是因为setState是由volatile修饰的，可以防止指令重排，让其他线程可见当前线程释放了锁
         * @param arg
         * @return
         */
        @Override
        protected boolean tryRelease(int arg) {
            // 设置owner为null
            setExclusiveOwnerThread(null);
            // 设置状态为0；因为释放锁没有其他线程进行竞争，所以可以不用cas操作
            setState(0);
            return true;
        }

        // 是否持有独占锁
        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        // 返回条件变量
        public Condition newCondition() {
            return new ConditionObject();
        }
    }

    private MySync sync = new MySync();


    // 加锁（不成功就进入等待队列等待）
    @Override
    public void lock() {
        sync.acquire(1);
    }

    // 加锁：可打断
    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    // 尝试加锁（一次）
    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    // 尝试加锁，带超时
    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1,unit.toNanos(time));
    }

    // 解锁
    @Override
    public void unlock() {
        sync.release(1);
    }

    // 创建条件变量
    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }
}
