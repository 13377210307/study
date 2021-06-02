package com.study.newDesignModel.obserevr.example1.pushVersion;

import cn.hutool.core.collection.CollectionUtil;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: w
 * @Date: 2021/6/2 17:41
 * 抽象主题类：包含多个观察者
 */
@Data
public abstract class Subject {

    private List<Observer> observers = new ArrayList<>();

    private String name;

    // 新增观察者
    void addObserver(Observer observer) {
        observers.add(observer);
    }

    // 移除观察者
    void removeObserver(Observer observer) {
        if (CollectionUtil.isNotEmpty(observers)) {
            observers.remove(observer);
        }
    }

    // 通知方法
    void notifyAllObservers(String msg) {
        if (CollectionUtil.isNotEmpty(observers)) {
            for (Observer observer : observers) {
                observer.updateData(this.name,msg);
            }
        }
    }

}
