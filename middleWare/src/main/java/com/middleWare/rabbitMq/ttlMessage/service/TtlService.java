package com.middleWare.rabbitMq.ttlMessage.service;

/**
 * @Author: w
 * @Date: 2021/6/6 10:11
 */
public interface TtlService {

    // 设置单条消息ttl
    void sendMessageTTl();

    // 设置某个队列的消息ttl
    void sendQueueTTl();
}
