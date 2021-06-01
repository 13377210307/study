package com.study.newDesignModel.obserevr.newVersion;

/**
 * @Author: w
 * @Date: 2021/6/1 22:07
 * 事件监听接口具体实现类
 */
public class MessageEventListener implements EventListener {


    @Override
    public void doEvent(String msg) {
        System.out.println("短信发送消息：" + msg);
    }
}
