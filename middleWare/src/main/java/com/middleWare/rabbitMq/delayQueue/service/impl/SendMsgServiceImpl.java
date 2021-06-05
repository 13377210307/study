package com.middleWare.rabbitMq.delayQueue.service.impl;

import com.middleWare.rabbitMq.delayQueue.enums.MqEnum;
import com.middleWare.rabbitMq.delayQueue.service.SendMsgService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author: w
 * @Date: 2021/6/5 11:40
 */
@Service
public class SendMsgServiceImpl implements SendMsgService {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Override
    public void sendMsg() {
        System.out.println("发送消息...." + new Date());
        this.rabbitTemplate.convertAndSend(MqEnum.DELAY_EXCHANGE.name,MqEnum.DELAY_ROUTING_KEY.name,"测试延时队列");
    }
}
