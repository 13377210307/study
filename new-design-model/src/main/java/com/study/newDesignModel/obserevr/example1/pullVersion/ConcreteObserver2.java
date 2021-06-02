package com.study.newDesignModel.obserevr.example1.pullVersion;

import lombok.Data;

/**
 * @Author: w
 * @Date: 2021/6/2 18:27
 */
@Data
public class ConcreteObserver2 implements Observer {

    private String content;

    @Override
    public void updateData(Subject subject) {
        if (subject.getMsg().contains(content)) {
            // 观察者感兴趣的内容才进行拉取
            System.out.println("电脑端：您关注的主题：" + "给您发送了一条信息：" + subject.getMsg() );
        }
    }
}
