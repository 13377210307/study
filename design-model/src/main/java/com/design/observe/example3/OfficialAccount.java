package com.design.observe.example3;

import cn.hutool.core.collection.CollectionUtil;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: w
 * @Date: 2021/5/28 11:35
 */
@Data
public abstract class OfficialAccount {

    private String name;

    private String article;

    private List<OfficialAccountObserver> observers = new ArrayList<>();

    // 添加观察者
    public void addObserver(OfficialAccountObserver observer) {
        observers.add(observer);
    }

    // 移除观察者
    public void removeObserver(OfficialAccountObserver observer) {
        if (CollectionUtil.isNotEmpty(observers)) {
            observers.remove(observer);
        }
    }

    // 通知所有观察者
    public void notifyAllObserver() {
        if (CollectionUtil.isNotEmpty(observers)) {
            for (OfficialAccountObserver observer : observers) {
                observer.updateData();
            }
        }
    }

}
