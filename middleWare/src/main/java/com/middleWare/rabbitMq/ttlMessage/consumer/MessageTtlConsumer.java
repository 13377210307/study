package com.middleWare.rabbitMq.ttlMessage.consumer;


import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: w
 * @Date: 2021/6/6 10:18
 */
@Component
public class MessageTtlConsumer {

    @RabbitListener(queues = "ttlMessageQueue")
    public void receiverMessageTtl(Message message) {
        System.out.println(message.getBody());
    }

    @RabbitListener(queues = "ttlQueueQueue")
    public void receiverQueueTtl(Message message) {
        System.out.println(message.getBody());
    }
}
