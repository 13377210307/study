package com.study.newDesignModel.obserevr.example1.pushVersion;

import lombok.Data;

/**
 * @Author: w
 * @Date: 2021/6/2 17:53
 */
public class ConcreteObserver2 implements Observer {

    @Override
    public void updateData(String subjectName, String msg) {
        System.out.println("电脑端：您关注的主题：" + subjectName + "给您发送了一条信息：" + msg );
    }
}
