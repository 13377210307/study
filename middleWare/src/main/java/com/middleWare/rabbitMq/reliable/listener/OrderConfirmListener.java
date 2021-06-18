package com.middleWare.rabbitMq.reliable.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author: w
 * @Date: 2021/6/18 15:17
 */
@Component
public class OrderConfirmListener {

    @RabbitListener(queues = "orderConfirmQueue")
    @RabbitHandler
    public void handler(Message message, Channel channel) throws IOException {
        System.out.println("消费方收到消息....");
    }
}
