package com.middleWare.rabbitMq.delayQueue.consumer;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

/**
 * @Author: w
 * @Date: 2021/6/5 11:37
 */
@Component
public class DelayDeadLetterConsumer {

    @RabbitListener(queues = "delayDeadLetterQueue")
    public void delayReceiveMsg(Message message, Channel channel) throws IOException {
        System.out.println("=====================" + new Date());
        System.out.println("延时死信队列消费到了消息" + message.getBody());
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
}
