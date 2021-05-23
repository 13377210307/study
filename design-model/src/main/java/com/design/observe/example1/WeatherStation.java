package com.design.observe.example1;

import cn.hutool.core.collection.CollectionUtil;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: w
 * @Date: 2021/5/19 8:45
 */
@Data
public class WeatherStation {

    private String name;

    private Integer temperature;

    private Integer press;

    private Integer humidity;

    private List<Observer> observers = new ArrayList<>();

    // 添加观察者
    public void addObservers(Observer observer) {
        this.observers.add(observer);
    }

    // 移除观察者
    public void removeObservers(Observer observer) {
        if (CollectionUtil.isNotEmpty(observers)) {
            observers.remove(observer);
        }
    }

    // 通知观察者
    public void noticeAllObservers() {
        if (CollectionUtil.isNotEmpty(observers)) {
            observers.forEach(Observer::updateData);
        }
    }


}
