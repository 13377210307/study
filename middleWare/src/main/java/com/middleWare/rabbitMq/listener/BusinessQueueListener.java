package com.middleWare.rabbitMq.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author: w
 * @Date: 2021/6/3 12:24
 */
@Component
public class BusinessQueueListener {

    @RabbitListener(queues = "businessQueue")
    @RabbitHandler
    public void handler(Message message, Channel channel) throws IOException {
        String msg = new String(message.getBody());
        System.out.println("收到业务消息");
        //boolean ack = true;
        boolean ack = false;
        Exception exception = null;
        try {
            if (msg.contains("deadletter")){
                throw new RuntimeException("dead letter exception");
            }
        } catch (Exception e){
            ack = false;
            exception = e;
        }
        if (!ack){
            System.out.println("消息消费发生异常");
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
        } else {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        }
    }
}
