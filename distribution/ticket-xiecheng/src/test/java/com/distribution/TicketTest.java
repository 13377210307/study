package com.distribution;

import com.distribution.utils.DistributionLock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * @Author: w
 * @Date: 2021/7/21 8:48
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TicketTest {

    @Autowired
    private DistributionLock distributionLock;

    private Integer count = 10;

    @Test
    public void testRedisson() {
        while (count > 0) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 500; i++) {
                int thread = i + 1;
                for (int j = 0; j < count; j++) {
                    Integer num = j;
                    new Thread(() -> {
                        getTicket(num);
                    }, "嘉宾" + thread).start();
                }
            }
        }

}

    private void getTicket(Integer num) {
        String lockKey = "lock_" + num;
        try {
            System.out.println(Thread.currentThread().getName() + "开始抢票");
            boolean lock = distributionLock.newTryLock(lockKey, TimeUnit.SECONDS, 1L, 1L);
            if (lock) {
                while (count > 0) {
                    System.out.println(Thread.currentThread().getName() + "抢到了" + count + "号票，" + "还剩" + (--count) + "张票");
                    TimeUnit.SECONDS.sleep(1);
                }
                System.out.println("暂无余票");
            }
            // 释放锁
            distributionLock.unlock(distributionLock.lock("task"));
        } catch (Exception e) {
            System.out.println("很遗憾：" + Thread.currentThread().getName() + "抢票失败");
        }
    }


}
