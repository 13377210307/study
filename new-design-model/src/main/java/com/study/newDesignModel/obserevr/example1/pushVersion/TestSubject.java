package com.study.newDesignModel.obserevr.example1.pushVersion;

/**
 * @Author: w
 * @Date: 2021/6/2 17:57
 */
public class TestSubject {

    public static void main(String[] args) {
        // 创建主题
        ConcreteSubject concreteSubject = new ConcreteSubject();

        // 创建观察者
        Observer concreteObserver1 = new ConcreteObserver1();
        Observer concreteObserver2 = new ConcreteObserver2();

        // 加入观察者
        concreteSubject.addObserver(concreteObserver1);
        concreteSubject.addObserver(concreteObserver2);

        // 设置数据
        concreteSubject.setName("java主题");
        concreteSubject.setMsg("java8新特性实战");

        concreteSubject.removeObserver(concreteObserver2);
        concreteSubject.setMsg("java多线程实战");

    }
}
