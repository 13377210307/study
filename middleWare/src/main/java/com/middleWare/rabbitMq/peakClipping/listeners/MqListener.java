package com.middleWare.rabbitMq.peakClipping.listeners;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

/**
 * @Author: w
 * @Date: 2021/6/18 9:14
 */
@Component
public class MqListener {

    private static Integer count = 0;

    // 削峰队列
    @RabbitListener(queues = "peakQueue")
    public void delayReceiveMsg(Message message, Channel channel) throws IOException {
        count++;
        System.out.println("=====================" + new Date());
        System.out.println("削峰队列消费到了消息" + message.getBody());
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        System.out.println(count);
    }


}
