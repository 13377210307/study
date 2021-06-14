package com.middleWare.rabbitMq.delayQueue.service;

/**
 * @Author: w
 * @Date: 2021/6/7 8:58
 */
public interface DelayRefundService {

    void sendMsg(String consumer);
}
