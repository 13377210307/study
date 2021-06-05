package com.middleWare.rabbitMq.deadLetter.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author: w
 * @Date: 2021/6/3 14:36
 */
@Component
public class DeadLetterQueueListener {

    @RabbitListener(queues = "deadLetterQueue")
    @RabbitHandler
    public void handler(Message message, Channel channel) throws IOException {
        System.out.println("收到死信消息A：" + new String(message.getBody()));
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
}
