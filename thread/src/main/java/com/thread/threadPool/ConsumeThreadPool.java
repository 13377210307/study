package com.thread.threadPool;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: w
 * @Date: 2021/6/20 10:52
 * 自定义线程池
 *
 * 出现背景：
 * 1：每创建一个线程，都需要占用一定的内存；若高并发情况下，每个任务都创建一个线程，可能会出现内存溢出
 * 2：多个线程创建会引起线程上下文切换问题
 *
 * 组成：
 * 1：线程池：创建线程
 * 2：阻塞队列：用于平衡生产者、消费者的关系
 * （1）生产者生产任务过多：线程池中的线程无法一时处理太多任务就可以先放到阻塞队列中
 * （2）生产者没有生产：线程池中的线程就可以放在阻塞队列中直到有新任务进来
 *
 *
 */
public class ConsumeThreadPool {
}

class ThreadPool {
    // 任务队列
    private BlockingQueue<Runnable> taskQueue;

    // 线程集合
    private HashSet<Worker> workers = new HashSet();

    // 核心线程数
    private int coreSize;

    // 获取任务的超时时间
    private long timeout;

    // 时间单位
    private TimeUnit timeUnit;


    class Worker {

    }
}

class BlockQueue<T> {

    // 任务队列：由于先进先出，采用双向链表实现
    private Deque<T> queue = new ArrayDeque<>();

    // 锁
    private ReentrantLock lock = new ReentrantLock();

    // 生产者条件变量：在阻塞队列满的时候，生产线程进行等待
    private Condition fullWaitSet = lock.newCondition();

    // 消费者条件变量：在阻塞队列为空的时候，消费线程进行等待
    private Condition emptyWaitSet = lock.newCondition();

    // 容量
    private int capcity;

    public BlockQueue(int capcity) {
        this.capcity = capcity;
    }

    /**
     * 带超时的阻塞获取
     */
    public T poll(Long timeout, TimeUnit unit) {
        lock.lock();
        try {
            // 将timeout统一转为纳秒
            long nanos = unit.toNanos(timeout);
            while (queue.isEmpty()) {
                // 队列为空，消费线程等待
                try {
                    // 返回剩余时间
                    if (nanos <= 0) {
                        return null;
                    }
                    nanos = emptyWaitSet.awaitNanos(nanos);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 不为空，获取队列中第一个任务
            T t = queue.removeFirst();
            // 唤醒生产线程
            fullWaitSet.signal();
            return t;
        }finally {
            lock.unlock();
        }
    }

    /**
     * 阻塞获取
     */
    public T take() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                // 队列为空，消费线程等待
                try {
                    emptyWaitSet.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 不为空，获取队列中第一个任务
            T t = queue.removeFirst();
            // 唤醒生产线程
            fullWaitSet.signal();
            return t;
        }finally {
            lock.unlock();
        }
    }

    /**
     * 阻塞添加
     */
    public void put(T element) {
        lock.lock();
        try {
            while (queue.size() >= capcity) {
                // 队列大小是否超过阻塞队列容量，生产线程等待
                try {
                    fullWaitSet.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 没有超过，进行生产
            queue.addFirst(element);
            // 唤醒消费者
            emptyWaitSet.signal();
        }finally {
            lock.unlock();
        }
    }

    /**
     * 获取阻塞队列大小
     */
    public int getSize() {
        lock.lock();
        try {
            return queue.size();
        }finally {
            lock.unlock();
        }
    }

}
