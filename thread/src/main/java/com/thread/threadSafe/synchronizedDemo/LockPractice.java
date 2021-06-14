package com.thread.threadSafe.synchronizedDemo;

import java.util.concurrent.TimeUnit;

/**
 * @Author: w
 * @Date: 2021/6/14 15:09
 * 线程八锁练习：考察synchronized锁住了哪个对象
 */
public class LockPractice {

    public static void main(String[] args) {
        Number number = new Number();
        new Thread(() -> {
            System.out.println("begin...");
            number.a1();
        }).start();

        new Thread(() -> {
            System.out.println("begin...");
            number.b1();
        }).start();
    }

}

class Number {

    /*-------------情况1：锁住this对象  1,2或2,1-----------*/
    public synchronized void a() {
        System.out.println("1");
    }
    public synchronized void b() {
        System.out.println("2");
    }

    /*-------------情况2：锁住this对象  1秒后1,2或2,1秒后1-----------*/
    public synchronized void a1() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("1");
    }
    public synchronized void b1() {
        System.out.println("2");
    }

    /*-------------情况3：a2,b2锁住this对象  3,1秒后1,2或3,2,1秒后1或2,3,1秒后1-----------*/
    public synchronized void a2() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("1");
    }
    public synchronized void b2() {
        System.out.println("2");
    }
    public void c2() {
        System.out.println("3");
    }

    /**
     * 情况4：
     * a方法是static：所以锁住的是number类；
     * b方法没有static，所以锁住的是this；
     * 由于两个对象不同，所以不互斥
     */
    public static synchronized void a3() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("1");
    }
    public synchronized void b3() {
        System.out.println("2");
    }

    /**
     * 情况5：
     * Number number1 = new Number();
     * Number number2 = new Number();
     * number1.a()
     * number2.b()
     * a方法是static：所以锁住的是number类；
     * b方法是static，所以锁住的是number类；
     * 互斥
     */
    public static synchronized void a4() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("1");
    }
    public static synchronized void b4() {
        System.out.println("2");
    }


}
