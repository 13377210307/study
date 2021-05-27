package com.design.bridge.example2.common;

import lombok.Data;

import java.util.List;

/**
 * @Author: w
 * @Date: 2021/5/27 9:20
 */
@Data
public class Notification {

    private List<String> emailList;

    private List<String> phoneList;

    private List<String> wechatList;

    // 发送消息
    public void sendMessage(String level) {
        if (level.equals(NotificationLevel.SEVERE)) {
            System.out.println("发送严重消息...");
        }else if(level.equals(NotificationLevel.URGENCY)) {
            System.out.println("发送紧急消息...");
        }else if (level.equals(NotificationLevel.NORMAL)) {
            System.out.println("发送正常消息...");
        }else if (level.equals(NotificationLevel.TRIVIAL)) {
            System.out.println("发送可忽略消息...");
        }
    }
}
