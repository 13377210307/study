package com.thread.jmm;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @Author: w
 * @Date: 2021/7/7 22:28
 * double-checked locking案例
 */
@Slf4j
public class DclDemo {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                Singleton instance = Singleton.getInstance();
                log.debug("创建对象为：{}",instance);
            }).start();
        }
    }

}

/**
 * 实现特点
 * 懒惰实例化
 * 首次使用getInstance()才使用synchronized加锁，后续使用时无需加锁
 * 有隐含的、关键的一点：第一个if使用了INSTANCE变量，是在同步代码块之外
 * 由于第一个if判断在monitor控制之外，其他线程就可以越过monitor读取INSTANCE变量的值，
 * 这时t1线程还未完全将构造方法执行完毕，如果构造方法钟要执行很多初始化操作，那么t2线程拿到的是一个未初始化完毕的单例
 * 我们这时可以通过volatile修饰INSTANCE变量，禁止指令重排；
 */
class Singleton {

    private Singleton() {}

    private static Singleton INSTANCE = null;

    private static volatile Singleton INSTANCE1 = null;

    // 第一次检验INSTANCE为不为空，第二次再次检验INSTANCE是否为空，将锁加载判断INSTANCE里面，提高性能：实现首次访问加同步，之后不需要synchronized
    public static Singleton getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton.class) {
                if (INSTANCE == null) {
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }

    public static Singleton getInstance1() {
        if (INSTANCE1 == null) {
            synchronized (Singleton.class) {
                if (INSTANCE1 == null) {
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE1 = new Singleton();
                }
            }
        }
        return INSTANCE1;
    }
}
