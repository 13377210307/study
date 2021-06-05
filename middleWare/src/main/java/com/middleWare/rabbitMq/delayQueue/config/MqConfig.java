package com.middleWare.rabbitMq.delayQueue.config;

import com.middleWare.rabbitMq.delayQueue.enums.MqEnum;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: w
 * @Date: 2021/6/5 11:19
 * 延时队列配置
 */
@Configuration
public class MqConfig {

    // 声明交换机
    @Bean
    public DirectExchange delayExchange() {
        return new DirectExchange(MqEnum.DELAY_EXCHANGE.name);
    }

    @Bean
    public DirectExchange delayDeadLetterExchange() {
        return new DirectExchange(MqEnum.DELAY_DEAD_LETTER_EXCHANGE.name);
    }

    // 声明队列：给延时队列设置延时时间，到了指定时间投递到死信队列
    @Bean
    public Queue delayQueue() {
        Map<String,Object> args = new HashMap<>();
        // 先声明需要绑定的死信交换机
        args.put("x-dead-letter-exchange",MqEnum.DELAY_DEAD_LETTER_EXCHANGE.name);
        // 声明当前队列投递到死信队列的路由
        args.put("x-dead-letter-routing-key",MqEnum.DELAY_DEAD_LETTER_ROUTING_KEY.name);
        // 设置队列ttl
        args.put("x-message-ttl",6000);
        return QueueBuilder.durable(MqEnum.DELAY_QUEUE.name).withArguments(args).build();
    }

    @Bean
    public Queue delayDeadLetterQueue() {
        return new Queue(MqEnum.DELAY_DEAD_LETTER_QUEUE.name);
    }

    // 绑定
    @Bean
    public Binding delayBinding() {
        return BindingBuilder.bind(delayQueue()).to(delayExchange()).with(MqEnum.DELAY_ROUTING_KEY.name);
    }

    @Bean
    public Binding delayDeadLetterBinding() {
        return BindingBuilder.bind(delayDeadLetterQueue()).to(delayDeadLetterExchange()).with(MqEnum.DELAY_DEAD_LETTER_ROUTING_KEY.name);
    }


}
