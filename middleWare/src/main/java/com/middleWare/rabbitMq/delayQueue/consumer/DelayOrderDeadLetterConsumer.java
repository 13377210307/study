package com.middleWare.rabbitMq.delayQueue.consumer;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author: w
 * @Date: 2021/6/5 18:40
 */
@Component
public class DelayOrderDeadLetterConsumer {

    @RabbitListener(queues = "delayOrderDeadLetterQueue")
    public void receive(Message message, Channel channel) throws IOException {
        // 根据订单号查询是否支付
        System.out.println("抱歉，您的订单" + message +"在十分钟内未进行支付，已取消");
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }

    @RabbitListener(queues = "delayRefundOrderQueue")
    public void receiveRefund(Message message, Channel channel) throws IOException {
        // 根据订单号查询是否支付
        System.out.println("亲：您有一天新信息：" + message);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
}
