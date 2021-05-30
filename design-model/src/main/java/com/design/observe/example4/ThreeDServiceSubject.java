package com.design.observe.example4;

import cn.hutool.core.collection.CollectionUtil;

/**
 * @Author: w
 * @Date: 2021/5/30 11:24
 * 3d服务号
 */
public class ThreeDServiceSubject extends Subject {

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if (CollectionUtil.isNotEmpty(observers)) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyAllObservers() {
        if (CollectionUtil.isNotEmpty(observers)) {
            for (Observer observer : observers) {
                observer.updateData(this.name,this.msg);
            }
        }
    }

}
