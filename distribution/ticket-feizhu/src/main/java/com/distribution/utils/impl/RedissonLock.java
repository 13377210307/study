package com.distribution.utils.impl;

import com.distribution.utils.DistributionLock;
import org.redisson.api.RLock;
import org.redisson.api.RReadWriteLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * @Author: w
 * @Date: 2021/7/21 12:17
 */
@Component
public class RedissonLock implements DistributionLock {

    @Autowired
    private RedissonClient redissonClient;

    @Override
    public RLock lock(String key) {
        return redissonClient.getLock(key);
    }

    @Override
    public RLock fairLock(String key) {
        return redissonClient.getFairLock(key);
    }

    @Override
    public RReadWriteLock readWriteLock(String key) {
        return redissonClient.getReadWriteLock(key);
    }

    @Override
    public <T> T lock(String key, Supplier<T> supplier) {
        RLock lock = lock(key);
        try {
            lock.lock();
            return supplier.get();
        } finally {
            if (lock != null && lock.isLocked()) {
                lock.unlock();
            }
        }
    }

    @Override
    public <T> T lock(String key, int leaseTime, TimeUnit unit, Supplier<T> supplier) {
        RLock lock = this.lock(key);
        try {
            lock.lock(leaseTime, unit);
            return supplier.get();
        } finally {
            unlock(lock);
        }
    }

    @Override
    public <T> T tryLock(String key, Supplier<T> supplier) {
        RLock lock = this.lock(key);
        boolean tryLock = false;
        try {
            tryLock = lock.tryLock();
            if (tryLock) {
                return supplier.get();
            }
        } finally {
            if (tryLock) {
                unlock(lock);
            }
        }
        return null;
    }

    @Override
    public <T> T tryLock(String key, long waitTime, TimeUnit unit, Supplier<T> supplier) throws InterruptedException {
        RLock lock = this.lock(key);
        boolean tryLock = false;
        try {
            tryLock = lock.tryLock(waitTime, unit);
            if (tryLock) {
                return supplier.get();
            }
        } finally {
            if (tryLock) {
                unlock(lock);
            }
        }
        return null;
    }

    @Override
    public Boolean newTryLock(String lockKey, TimeUnit unit, long waitTime, long leaseTime) {
        RLock lock = redissonClient.getLock(lockKey);
        try {
            return lock.tryLock(waitTime, leaseTime, unit);
        } catch (InterruptedException e) {
            return false;
        }
    }

    @Override
    public <T> T trysLock(String key, long waitTime, int leaseTime, TimeUnit unit, Supplier<T> supplier) throws InterruptedException {
        RLock lock = this.lock(key);
        boolean tryLock = false;
        try {
            tryLock = lock.tryLock(waitTime, leaseTime, unit);
            if (tryLock) {
                return supplier.get();
            }
        } finally {
            if (tryLock) {
                unlock(lock);
            }
        }
        return null;
    }
}
