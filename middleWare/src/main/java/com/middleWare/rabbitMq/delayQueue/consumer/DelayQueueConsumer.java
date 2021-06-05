package com.middleWare.rabbitMq.delayQueue.consumer;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: w
 * @Date: 2021/6/5 11:34
 */
@Component
public class DelayQueueConsumer {

    //@RabbitListener(queues = "delayQueue")
    public void delayReceiveMsg(Message message, Channel channel) {
        System.out.println("=====================" + new Date());
        System.out.println("延时队列消费到了消息" + message.getBody());
    }
}
