package com.distribution.utils;

import org.redisson.api.RLock;
import org.redisson.api.RReadWriteLock;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * @Author: w
 * @Date: 2021/7/21 12:13
 * 分布式锁接口
 */
public interface DistributionLock {

    /**
     * 锁名称前缀
     */
    String LOCK_KEY_PREFIX_KEY = "distribution:ticketLock:";

    /**
     * 可重入锁
     */
    RLock lock(String key);

    /**
     * 公平锁
     */
    RLock fairLock(String key);

    /**
     * 读写锁
     */
    RReadWriteLock readWriteLock(String key);

    /**
     * 在锁内执行业务
     */
    <T> T lock(String key, Supplier<T> supplier);

    /**
     * 可重入锁(设置锁的持有时间)
     */
    <T> T lock(String key, int leaseTime, TimeUnit unit, Supplier<T> supplier);

    /**
     * 尝试获取锁
     */
    <T> T tryLock(String key, Supplier<T> supplier);

    /**
     * 尝试获取锁(为加锁等待 waitTime unit时间)
     */
    <T> T tryLock(String key, long waitTime, TimeUnit unit, Supplier<T> supplier)
            throws InterruptedException;

    /**
     * 尝试获取锁(为加锁等待 waitTime unit时间，并在加锁成功 leaseTime unit 后自动解开)
     */
    <T> T trysLock(String key, long waitTime, int leaseTime, TimeUnit unit, Supplier<T> supplier)
            throws InterruptedException;

    Boolean newTryLock(String lockKey, TimeUnit unit, long waitTime, long leaseTime);

    /**
     * 解锁
     */
    default void unlock(RLock lock) {
        if (lock != null && lock.isLocked()) {
            lock.unlock();
        }
    }
}
