package com.design.observe.example4;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: w
 * @Date: 2021/5/30 11:21
 */
public abstract class Subject {

    public String msg;

    public String name;

    public List<Observer> observers = new ArrayList<>();

    // 新增观察者
    abstract void addObserver(Observer observer);

    // 移除观察者
    abstract void removeObserver(Observer observer);

    // 通知观察者
    abstract void notifyAllObservers();

    public String getMsg() {
        return msg;
    }

    // 设置消息的时候调用通知方法
    public void setMsg(String msg) {
        this.msg = msg;
        this.notifyAllObservers();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }
}
