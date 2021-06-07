package com.middleWare.rabbitMq.ttlMessage.config;

import com.middleWare.rabbitMq.ttlMessage.enums.MqEnum;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: w
 * @Date: 2021/6/6 10:03
 * 单条消息ttl
 */
@Configuration
public class MessageTtlConfig {

    // 声明交换机
    @Bean
    public DirectExchange ttlMessageExchange() {
        return new DirectExchange(MqEnum.TTL_MESSAGE_EXCHANGE.name);
    }

    @Bean
    public DirectExchange ttlQueueExchange() {
        return new DirectExchange(MqEnum.TTL_QUEUE_EXCHANGE.name);
    }

    // 声明队列
    @Bean
    public Queue ttlMessageQueue() {
        return new Queue(MqEnum.TTL_MESSAGE_QUEUE.name);
    }

    @Bean
    public Queue ttlQueueQueue() {
        Map<String,Object> args = new HashMap<>();
        // 设置ttl
        args.put("x-message-ttl",5000);
        return new Queue(MqEnum.TTL_QUEUE_QUEUE.name,true,false,false,args);
    }

    // 绑定
    @Bean
    public Binding ttlMessageBinding() {
        return BindingBuilder.bind(ttlMessageQueue()).to(ttlMessageExchange()).with(MqEnum.TTL_MESSAGE_ROUTING_KEY.name);
    }

    @Bean
    public Binding ttlQueueBinding() {
        return BindingBuilder.bind(ttlQueueQueue()).to(ttlQueueExchange()).with(MqEnum.TTL_QUEUE_ROUTING_KEY.name);
    }
}
