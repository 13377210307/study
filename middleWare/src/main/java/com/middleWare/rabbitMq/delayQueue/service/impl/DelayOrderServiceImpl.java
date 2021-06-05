package com.middleWare.rabbitMq.delayQueue.service.impl;

import com.middleWare.rabbitMq.delayQueue.enums.MqEnum;
import com.middleWare.rabbitMq.delayQueue.service.DelayOrderService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: w
 * @Date: 2021/6/5 18:29
 */
@Service
public class DelayOrderServiceImpl implements DelayOrderService {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Override
    public void sendMsg() {
        this.rabbitTemplate.convertAndSend(MqEnum.DELAY_ORDER_EXCHANGE.name,MqEnum.DELAY_ORDER_ROUTING_KEY.name,"订单支付超时信息");
    }
}
