package com.middleWare.rabbitMq.delayQueue.service;

/**
 * @Author: w
 * @Date: 2021/6/24 18:09
 * 延时支付
 */
public interface DelayPayService {

    void sendPayMessage(String user);
}
