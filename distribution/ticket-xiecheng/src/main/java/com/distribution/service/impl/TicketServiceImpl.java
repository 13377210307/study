package com.distribution.service.impl;

import com.distribution.enums.RedisPathEnum;
import com.distribution.service.TicketService;
import com.distribution.utils.DistributionLock;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


/**
 * @Author: w
 * @Date: 2021/7/17 11:29
 */
@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private Redisson redisson;

    @Autowired
    private DistributionLock distributionLock;

    @Override
    public String buyTicket(Long userId) {
        return buyTicketVersion7(userId);
    }

    @Override
    public String newBuyTicket() {
        String num = this.redisTemplate.opsForValue().get(RedisPathEnum.TICKET_STOCK.path);
        Integer number = Integer.parseInt(num);
        String resMsg = null;
        String lockKey = "lock_" + num;
        try {
            System.out.println(Thread.currentThread().getName() + "开始抢票");
            boolean lock = distributionLock.newTryLock(lockKey, TimeUnit.SECONDS, 1L, 1L);
            if (lock) {
                if (number > 0) {
                    Integer finaCount = --number;
                    System.out.println("【携程旅行】：" + Thread.currentThread().getName() + "抢到了" + num + "号票，" + "还剩" + finaCount + "张票");
                    resMsg = "抢票成功...";

                    // 将票数重新设置到redis中
                    this.redisTemplate.opsForValue().set(RedisPathEnum.TICKET_STOCK.path,finaCount.toString());
                }else {
                    System.out.println("【携程旅行】：暂无余票");
                    resMsg = "暂无余票...";
                }
            }
            // 释放锁
            distributionLock.unlock(distributionLock.lock("task"));
        } catch (Exception e) {
            System.out.println("【携程旅行】：很遗憾：" + Thread.currentThread().getName() + "抢票失败");
            resMsg = "很遗憾：" + Thread.currentThread().getName() + "抢票失败";
        }
        return resMsg;
    }


    /**
     * 抢票版本七，通过redission解决
     */
    private String buyTicketVersion7(Long userId) {

        // 获取锁
        RLock lock = redisson.getLock(RedisPathEnum.TICKET_LOCK.path);
        Integer stock = Integer.parseInt(redisTemplate.opsForValue().get(RedisPathEnum.TICKET_STOCK.path));
        try {
            // 加锁
            lock.lock();
            if (stock > 0) {
                Integer realStock = stock - 1;
                redisTemplate.opsForValue().set(RedisPathEnum.TICKET_STOCK.path, realStock.toString());
                System.out.println("【携程旅行】：尊敬的" + userId + "号旅客：恭喜您抢票成功，您的票号为" + stock + "还剩" + realStock + "张票");
                return "【携程旅行】：尊敬的" + userId + "号旅客：恭喜您抢票成功，您的票号为" + stock + "还剩" + realStock + "张票";
            } else {
                System.out.println("票已售完....");
                return "票已售完....";
            }
        }finally {
            // 释放锁
            lock.unlock();
        }
    }


}

