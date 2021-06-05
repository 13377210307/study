package com.middleWare.rabbitMq.deadLetter.service.impl;

import com.middleWare.rabbitMq.deadLetter.enums.MqEnum;
import com.middleWare.rabbitMq.deadLetter.service.DeadLetterService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: w
 * @Date: 2021/6/3 12:17
 */
@Service
public class DeadLetterServiceImpl implements DeadLetterService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendMsgToDeadLetter(String msg) {
        this.rabbitTemplate.convertAndSend(MqEnum.BUSINESS_EXCHANGE.name,MqEnum.BUSINESS_ROUTING_KEY.name,"测试死信队列");
    }
}
