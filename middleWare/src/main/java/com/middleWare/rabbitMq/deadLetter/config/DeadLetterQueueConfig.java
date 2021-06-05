package com.middleWare.rabbitMq.deadLetter.config;

import com.middleWare.rabbitMq.deadLetter.enums.MqEnum;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: w
 * @Date: 2021/6/3 11:26
 * 死信队列配置
 */
@Configuration
public class DeadLetterQueueConfig {

    // 声明交换机
    @Bean
    public DirectExchange businessExchange() {
        return new DirectExchange(MqEnum.BUSINESS_EXCHANGE.name);
    }
    // 死信交换机
    @Bean
    public DirectExchange deadLetterExchange() {
        return new DirectExchange(MqEnum.DEAD_LETTER_EXCHANGE.name);
    }

    // 声明队列

    /**
     * 业务队列消息发生异常投递到死信队列
     * @return
     */
    @Bean
    public Queue businessQueue() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-dead-letter-exchange",MqEnum.DEAD_LETTER_EXCHANGE.name);
        args.put("x-dead-letter-routing-key",MqEnum.DEAD_LETTER_ROUTING_KEY.name);
        return QueueBuilder.durable(MqEnum.BUSINESS_QUEUE.name).withArguments(args).build();
    }
    // 死信队列
    @Bean
    public Queue deadLetterQueue() {
        return new Queue(MqEnum.DEAD_LETTER_QUEUE.name);
    }

    // 绑定交换机与队列
    @Bean
    public Binding businessBinding() {
        return BindingBuilder.bind(businessQueue()).to(businessExchange()).with(MqEnum.BUSINESS_ROUTING_KEY.name);
    }
    // 死信绑定
    @Bean
    public Binding deadLetterBinding() {
        return BindingBuilder.bind(deadLetterQueue()).to(deadLetterExchange()).with(MqEnum.DEAD_LETTER_ROUTING_KEY.name);
    }


}
