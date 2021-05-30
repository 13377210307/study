package com.design.observe.example4;

import cn.hutool.core.collection.CollectionUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: w
 * @Date: 2021/5/30 11:34
 */
public class SSQServiceSubject extends Subject {

    @Override
    public void addObserver(Observer observer) {
        super.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if (CollectionUtil.isNotEmpty(super.observers)) {
            super.observers.remove(observer);
        }
    }

    @Override
    public void notifyAllObservers() {
        if (CollectionUtil.isNotEmpty(super.observers)) {
            for (Observer observer : super.observers) {
                observer.updateData(this.name,this.msg);
            }
        }
    }
}
