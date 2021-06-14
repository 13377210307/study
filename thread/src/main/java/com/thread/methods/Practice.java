package com.thread.methods;

/**
 * @Author: w
 * @Date: 2021/6/13 22:08
 * 防止cpu占用100%
 * sleep实现
 * 在没有利用cpu来计算时，不要让while(true)空转浪费cpu，这时可以使用yield或sleep来让出cpu的使用权给其他程序
 * 可以用wait或条件变量达到类似的效果，不同的是，后两种都需要加锁，并且需要相应的唤醒条件，一般适用于要进行同步的场景；而sleep适用于无需锁同步的场景
 */
public class Practice {

    private void sleep() {
        while(true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
