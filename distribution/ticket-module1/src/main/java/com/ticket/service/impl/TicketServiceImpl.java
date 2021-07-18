package com.ticket.service.impl;

import com.ticket.enums.RedisPathEnum;
import com.ticket.service.TicketService;
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

    // 票数
    private static Integer ticketCount = 20;

    // 锁
    private static final Object LOCK = new Object();

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private Redisson redisson;

    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            Integer userId = i + 1;
            new Thread(() -> {
                //buyTicketVersion1(userId.longValue());
                buyTicketVersion2(userId.longValue());
            }, userId.toString()).start();
        }
    }


    @Override
    public String buyTicket(Long userId) {
        return buyTicketVersion4(userId);
    }

    /**
     * 抢票版本1
     * 容易造成超卖问题
     * 出现原因：while处当等于票数为1时多个线程同时满足条件，可能线程1先执行，执行完之后释放锁，余票为0，线程2进入，票数-1
     */
    private static void buyTicketVersion1(Long userId) {
        while(ticketCount > 0) {
            synchronized (LOCK) {
                System.out.println("尊敬的" + userId + "号旅客：恭喜您抢票成功，您的票号为" + ticketCount + "还剩" + ticketCount-- + "张票");
                /*try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
        }
    }

    /**
     * 抢票版本二：
     * 在while处的票数是不在synchronized的范围中的，所以我们需要将这个共享变量放入synchronized中
     */
    private static void buyTicketVersion2(Long userId) {
        while(true) {
            synchronized (LOCK) {
                if (ticketCount > 0) {
                    System.out.println("尊敬的" + userId + "号旅客：恭喜您抢票成功，您的票号为" + ticketCount + "还剩" + ticketCount-- + "张票");
                }else {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("票已售完....");
                }
                /*try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
        }
    }


    /**
     * 抢票版本三：在单线程下锁确实能解决多线程问题，但是在分布式项目中，synchronized控制不了
     * 普通版本：不加锁：会出现多个人抢到同一张票
     *
     */
    private String buyTicketVersion3(Long userId) {
        Integer stock = Integer.parseInt(redisTemplate.opsForValue().get(RedisPathEnum.TICKET_STOCK.path));
        if (stock > 0) {
            Integer realStock = stock -1;
            redisTemplate.opsForValue().set(RedisPathEnum.TICKET_STOCK.path,realStock.toString());
            System.out.println("【携程旅行】：尊敬的" + userId + "号旅客：恭喜您抢票成功，您的票号为" + stock + "还剩" + realStock + "张票");
            return "【携程旅行】：尊敬的" + userId + "号旅客：恭喜您抢票成功，您的票号为" + stock + "还剩" + realStock + "张票";
        }else {
            System.out.println("票已售完....");
            return "票已售完....";
        }
    }

    /**
     * 抢票版本四：通过synchronized修饰
     * 此方法虽然解决了多线程并发的情况，但如果是在分布式情况下，加synchronized是不起作用的，因为他们不是同一个jvm下的多个线程，synchronized只能解决当前jvm下的并发问题
     * 会引发超卖问题
     */
    private String buyTicketVersion4(Long userId) {
        synchronized (this) {
            Integer stock = Integer.parseInt(redisTemplate.opsForValue().get(RedisPathEnum.TICKET_STOCK.path));
            if (stock > 0) {
                Integer realStock = stock - 1;
                redisTemplate.opsForValue().set(RedisPathEnum.TICKET_STOCK.path, realStock.toString());
                System.out.println("【携程旅行】：尊敬的" + userId + "号旅客：恭喜您抢票成功，您的票号为" + stock + "还剩" + realStock + "张票");
                return "【携程旅行】：尊敬的" + userId + "号旅客：恭喜您抢票成功，您的票号为" + stock + "还剩" + realStock + "张票";
            } else {
                System.out.println("票已售完....");
                return "票已售完....";
            }
        }
    }

    /**
     * 抢票版本五，通过设置一个分布式锁解决
     * 这个锁就相当于synchronized，每次抢票之前先去判断这个锁有没有被其他服务持有（有值，释放锁的话会进行删除），若持有了就进行等待
     * 通过setnx命令判断该锁是否存在
     * 问题：
     * 1：redis宕机或服务出错，锁永远不能释放
     */
    private String buyTicketVersion5(Long userId) {

        Boolean isExit = redisTemplate.opsForValue().setIfAbsent(RedisPathEnum.TICKET_LOCK.path,userId.toString());  // 相当于setnx命令

        if (!isExit) {
            return "正在为您抢票，请稍候...";
        }

        Integer stock = Integer.parseInt(redisTemplate.opsForValue().get(RedisPathEnum.TICKET_STOCK.path));
        if (stock > 0) {
            Integer realStock = stock - 1;
            redisTemplate.opsForValue().set(RedisPathEnum.TICKET_STOCK.path, realStock.toString());
            System.out.println("【携程旅行】：尊敬的" + userId + "号旅客：恭喜您抢票成功，您的票号为" + stock + "还剩" + realStock + "张票");
            // 释放锁
            redisTemplate.delete(RedisPathEnum.TICKET_LOCK.path);
            return "【携程旅行】：尊敬的" + userId + "号旅客：恭喜您抢票成功，您的票号为" + stock + "还剩" + realStock + "张票";
        } else {
            System.out.println("票已售完....");
            // 释放锁
            redisTemplate.delete(RedisPathEnum.TICKET_LOCK.path);
            return "票已售完....";
        }
    }

    /**
     * 抢票版本六，通过设置过期时间释放锁
     * 问题：
     * 1：处理过程过长，可能出现购票不成功情况：过期时间不能控制好
     */
    private String buyTicketVersion6(Long userId) {

        // 设置10秒自动过期
        Boolean isExit = redisTemplate.opsForValue().setIfAbsent(RedisPathEnum.TICKET_LOCK.path,userId.toString(),10,TimeUnit.SECONDS);  // 相当于setnx命令

        if (!isExit) {
            return "正在为您抢票，请稍候...";
        }

        Integer stock = Integer.parseInt(redisTemplate.opsForValue().get(RedisPathEnum.TICKET_STOCK.path));
        try {
            if (stock > 0) {
                Integer realStock = stock - 1;
                redisTemplate.opsForValue().set(RedisPathEnum.TICKET_STOCK.path, realStock.toString());
                System.out.println("【携程旅行】：尊敬的" + userId + "号旅客：恭喜您抢票成功，您的票号为" + stock + "还剩" + realStock + "张票");
                // 释放锁
                redisTemplate.delete(RedisPathEnum.TICKET_LOCK.path);
                return "【携程旅行】：尊敬的" + userId + "号旅客：恭喜您抢票成功，您的票号为" + stock + "还剩" + realStock + "张票";
            } else {
                System.out.println("票已售完....");
                // 释放锁
                redisTemplate.delete(RedisPathEnum.TICKET_LOCK.path);
                return "票已售完....";
            }
        }finally {
            if (isExit) {
                // 释放锁
                redisTemplate.delete(RedisPathEnum.TICKET_LOCK.path);
            }
        }
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

