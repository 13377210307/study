package com.thread.practice;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * @Author: w
 * @Date: 2021/6/15 22:22
 * 转账
 * 分析：线程不安全
 * 出现在转账方法上：两个账户的余额都是共享变量；单纯在方法上加synchronized只能锁住this对象，也就是转账账户余额，对于目标账户余额无法进行保护
 * 解决：
 * 1：采用同步代码块，将Account类作为锁对象，转账账户和目标账户都是账户类，所以是线程安全：此方法性能较低，这样的话只能有两个账户转账，其他账户转账就必须等待
 */
@Slf4j
public class TransferAccount {

    private static Random random = new Random();

    // 随机1~5
    public static int randomAmount() {
        return random.nextInt(100) + 1;
    }

    public static void main(String[] args) {
        Account account = new Account(1000);
        Account targetAccount = new Account(1000);
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                account.transfer(targetAccount, randomAmount());
            }
        }, "t1");
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                targetAccount.transfer(account, randomAmount());
            }
        }, "t2");
        thread1.start();
        thread2.start();
        // 等待两个线程执行完
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 获取转账后两个账户的总额
        log.debug("两个账户总金额：{}", account.getMoney() + targetAccount.getMoney());
    }
}

@Data
class Account {

    private int money;

    public Account(int money) {
        this.money = money;
    }

    // 转账
    public void transfer(Account target, int money) {
        synchronized (Account.class) {
            if (this.money >= money) {
                this.setMoney(this.money - money);
                target.setMoney(target.money + money);
            }
        }
    }
}
