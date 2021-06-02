package com.study.newDesignModel.obserevr.example1.pullVersion;

import cn.hutool.core.collection.CollectionUtil;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: w
 * @Date: 2021/6/2 18:06
 */
public abstract class Subject {

    // 观察者
    List<Observer> observers = new ArrayList<>();

    private String name;

    private String msg;

    // 添加观察者
    void addObserver(Observer observer) {
        observers.add(observer);
    }

    // 移除观察者
    void removeObserver(Observer observer) {
        if (CollectionUtil.isNotEmpty(observers)) {
            observers.remove(observer);
        }
    }

    // 通知观察者
    void notifyAllObservers() {
        if (CollectionUtil.isNotEmpty(observers)) {
            for (Observer observer : observers) {
                observer.updateData(this);
            }
        }
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
        // 更新内容的时候就调用通知方法
        this.notifyAllObservers();
    }
}
