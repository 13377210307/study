package com.thread.createThread.runnable.basic;

/**
 * @Author: w
 * @Date: 2021/6/12 11:05
 * 实现Runnable接口
 * 1：定义MyRunnable类实现runnable接口
 * 2：实现run方法，编写方法体
 * 3：创建线程对象，调用start方法启动线程
 */
public class ImplementRunnable {

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        new Thread(myRunnable).start();
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "精神小伙" + i);
        }
    }
}


class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "你好啊！！！打工人" + i);
        }
    }

}
