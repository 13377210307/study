package com.middleWare.rabbitMq.delayQueue.config;

import com.middleWare.rabbitMq.delayQueue.enums.MqEnum;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: w
 * @Date: 2021/6/24 18:14
 */
@Configuration
public class PayDelayMqConfig {

    // 设置交换机
    @Bean
    public DirectExchange delayPayExchange() {
        return new DirectExchange(MqEnum.DELAY_PAY_EXCHANGE.name);
    }


}
