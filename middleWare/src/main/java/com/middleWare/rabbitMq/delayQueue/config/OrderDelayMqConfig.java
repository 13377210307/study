package com.middleWare.rabbitMq.delayQueue.config;

import com.middleWare.rabbitMq.delayQueue.enums.MqEnum;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: w
 * @Date: 2021/6/5 18:04
 */
@Configuration
public class OrderDelayMqConfig {

    // 定义交换机
    @Bean
    public DirectExchange delayOrderExchange() {
        return new DirectExchange(MqEnum.DELAY_ORDER_EXCHANGE.name);
    }

    @Bean
    public DirectExchange delayOrderDeadLetterExchange() {
        return new DirectExchange(MqEnum.DELAY_ORDER_DEAD_LETTER_EXCHANGE.name);
    }

    // 定义队列
    @Bean
    public Queue delayOrderQueue() {
        Map<String,Object> args = new HashMap<>();
        // 绑定死信交换机
        args.put("x-dead-letter-exchange",MqEnum.DELAY_ORDER_DEAD_LETTER_EXCHANGE.name);
        // 绑定死信路由
        args.put("x-dead-letter-routing-key",MqEnum.DELAY_ORDER_DEAD_LETTER_ROUTING_KEY.name);
        // 设置延时时间
        args.put("x-message-ttl",6000);
        return QueueBuilder.durable(MqEnum.DELAY_ORDER_QUEUE.name).withArguments(args).build();
    }

    @Bean
    public Queue delayOrderDeadLetterQueue() {
        return new Queue(MqEnum.DELAY_ORDER_DEAD_LETTER_QUEUE.name);
    }

    // 绑定
    @Bean
    public Binding delayOrderBinding() {
        return BindingBuilder.bind(delayOrderQueue()).to(delayOrderExchange()).with(MqEnum.DELAY_ORDER_ROUTING_KEY.name);
    }

    @Bean
    public Binding delayOrderDeadLetterBinding() {
        return BindingBuilder.bind(delayOrderDeadLetterQueue()).to(delayOrderDeadLetterExchange()).with(MqEnum.DELAY_ORDER_DEAD_LETTER_ROUTING_KEY.name);
    }
}
