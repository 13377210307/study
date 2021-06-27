package com.thread.reentrantLock.practice;

import com.thread.reentrantLock.practice.Chopstick;
import com.thread.reentrantLock.practice.Philosopher;

/**
 * @Author: w
 * @Date: 2021/6/26 15:49
 * 就餐问题
 * 有五位哲学家，围坐在圆桌旁边
 *   他们只做两件事，思考和吃饭，思考一会吃口饭，吃完饭后接着思考
 *   吃饭时要用两根筷子吃，桌上共有5根筷子，每位哲学家左右手边各有一根筷子
 *   如果筷子被身边的人拿着，自己就得呆着
 *
 */
public class EatProblem {

    public static void main(String[] args) {
        // 构造筷子对象
        Chopstick chopstick1 = new Chopstick("1");
        Chopstick chopstick2 = new Chopstick("2");
        Chopstick chopstick3 = new Chopstick("3");
        Chopstick chopstick4 = new Chopstick("4");
        Chopstick chopstick5 = new Chopstick("5");

        // 构造哲学家
        new Philosopher("苏格拉底",chopstick1,chopstick2).start();
        new Philosopher("泊拉图",chopstick2,chopstick3).start();
        new Philosopher("亚里士多德",chopstick3,chopstick4).start();
        new Philosopher("好垃克利特",chopstick4,chopstick5).start();
        new Philosopher("阿基米德",chopstick5,chopstick1).start();

    }



}
