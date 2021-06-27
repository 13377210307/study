package com.thread.practice.communication.providerAndConsumer;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: w
 * @Date: 2021/6/23 8:47
 * 信息队列
 * 队列包含容量以及队列集合
 * 生产消息方法和消费消息方法
 */
@Slf4j
public class MessageQueue {

    // 容量
    private int capcity;

    private LinkedList<Message> messages = new LinkedList<>();
}
