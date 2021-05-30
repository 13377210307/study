package com.design.observe.example4;

/**
 * @Author: w
 * @Date: 2021/5/30 11:44
 */
public class TestSubject {

    public static void main(String[] args) {
        // 创建观察者
        Observer realObServer1 = new ObServer1();
        Observer realObServer2 = new ObServer1();
        realObServer1.setName("老王");
        realObServer2.setName("小陈");

        // 创建主题
        Subject threeDServiceSubject = new ThreeDServiceSubject();
        Subject ssqServiceSubject = new SSQServiceSubject();

        // 加入观察者
        threeDServiceSubject.addObserver(realObServer1);
        threeDServiceSubject.addObserver(realObServer2);
        ssqServiceSubject.addObserver(realObServer2);

        // 通知
        threeDServiceSubject.setName("3D彩票服务号");
        threeDServiceSubject.setMsg("112200");

        ssqServiceSubject.setName("双色球服务号");
        ssqServiceSubject.setMsg("223300");
    }
}
