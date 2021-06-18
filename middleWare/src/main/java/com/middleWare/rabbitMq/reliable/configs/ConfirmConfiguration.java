package com.middleWare.rabbitMq.reliable.configs;

import com.middleWare.rabbitMq.reliable.enums.MqEnum;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: w
 * @Date: 2021/6/18 15:11
 */
@Configuration
public class ConfirmConfiguration {

    // 设置交换机
    @Bean
    public DirectExchange orderConfirmExchange() {
        return new DirectExchange(MqEnum.ORDER_CONFIRM_EXCHANGE.name);
    }

    // 设置队列
    @Bean
    public Queue orderConfirmQueue() {
        return new Queue(MqEnum.ORDER_CONFIRM_QUEUE.name);
    }

    // 绑定
    @Bean
    public Binding orderConfirmBinding() {
        return BindingBuilder.bind(orderConfirmQueue()).to(orderConfirmExchange()).with(MqEnum.ORDER_CONFIRM_ROUTING_KEY.name);
    }
}
