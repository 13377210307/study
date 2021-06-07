package com.middleWare.rabbitMq.ttlMessage.service.impl;

import com.middleWare.rabbitMq.ttlMessage.enums.MqEnum;
import com.middleWare.rabbitMq.ttlMessage.service.TtlService;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: w
 * @Date: 2021/6/6 10:12
 */
@Service
public class TtlServiceImpl implements TtlService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessageTTl() {
        MessagePostProcessor messagePostProcessor = new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                // 设置过期时间
                message.getMessageProperties().setExpiration("5000");
                // 设置编码格式
                message.getMessageProperties().setContentEncoding("UTF-8");
                return message;
            }
        };

        this.rabbitTemplate.convertAndSend(MqEnum.TTL_MESSAGE_EXCHANGE.name,MqEnum.TTL_MESSAGE_ROUTING_KEY.name,"单条消息设置ttl",messagePostProcessor);
    }

    @Override
    public void sendQueueTTl() {
        this.rabbitTemplate.convertAndSend(MqEnum.TTL_QUEUE_EXCHANGE.name,MqEnum.TTL_QUEUE_ROUTING_KEY.name,"某队列设置ttl");
    }
}
