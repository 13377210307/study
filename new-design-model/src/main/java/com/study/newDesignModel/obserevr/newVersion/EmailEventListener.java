package com.study.newDesignModel.obserevr.newVersion;

/**
 * @Author: w
 * @Date: 2021/6/1 22:09
 */
public class EmailEventListener implements EventListener {


    @Override
    public void doEvent(String msg) {
        System.out.println("邮件发送信息：" + msg);
    }
}
