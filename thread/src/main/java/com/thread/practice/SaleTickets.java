package com.thread.practice;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @Author: w
 * @Date: 2021/6/15 21:45
 * 卖票
 * 分析：出现线程安全问题的地方
 * 1：卖票方法：有共享变量count
 * 2：saleTickets.add(ticket);多个线程操作一个list，线程不安全；新增线程由于只有主线程进行新增，所以没有线程安全问题
 */
@Slf4j
public class SaleTickets {

    private static Random random = new Random();

    // 随机1~5
    public static int randomAmount() {
        return random.nextInt(5) + 1;
    }

    public static void main(String[] args) {
        TicketWindow ticketWindow = new TicketWindow(100);
        // 卖出去的票
        List<Integer> saleTickets = new Vector<>();
        // 线程集合
        List<Thread> threads = new ArrayList<>();
        // 模拟1000个人卖票
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(() -> {
                int ticket = ticketWindow.sellUnSafe(randomAmount());
                saleTickets.add(ticket);
            });
            threads.add(thread);
            thread.setName((i+1) + "号游客");
            thread.start();
        }

        // 统计卖出去的票与剩余票数，需要等卖票线程结束再统计
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        log.debug("余票：{}",ticketWindow.getCount());
        Integer count = 0;
        Optional<Integer> reduce = saleTickets.stream().filter(Objects::nonNull).reduce(Integer::sum);
        if (reduce.isPresent()) {
            count = reduce.get();
        }
        log.debug("卖出去的票为：{}",count);
    }
}

// 售票窗口
@Data
class TicketWindow {

    private int count;

    public TicketWindow(int count) {
        this.count = count;
    }

    // 售票（不安全）
    public synchronized int sellUnSafe(int mount) {
        if (this.count >= mount) {
            this.count -= mount;
            return mount;
        }else {
            return 0;
        }
    }
}
