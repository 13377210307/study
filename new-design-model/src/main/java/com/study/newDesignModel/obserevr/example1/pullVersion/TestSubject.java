package com.study.newDesignModel.obserevr.example1.pullVersion;


/**
 * @Author: w
 * @Date: 2021/6/2 18:35
 */
public class TestSubject {

    public static void main(String[] args) {
        // 创建主题
        ConcreteSubject concreteSubject = new ConcreteSubject();

        // 创建观察者
        ConcreteObserver1 concreteObserver1 = new ConcreteObserver1();
        ConcreteObserver2 concreteObserver2 = new ConcreteObserver2();
        // 设置观察者感兴趣的内容
        concreteObserver1.setContent("java8新特性实战");
        concreteObserver2.setContent("java多线程实战");

        // 加入观察者
        concreteSubject.addObserver(concreteObserver1);
        concreteSubject.addObserver(concreteObserver2);

        // 设置数据
        concreteSubject.setName("java主题");
        concreteSubject.setMsg("java8新特性实战");
        concreteSubject.setMsg("java多线程实战");
        concreteSubject.setMsg("java基础学习");
    }
}
