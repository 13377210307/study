package com.middleWare.rabbitMq.delayQueue.enums;

/**
 * @Author: w
 * @Date: 2021/6/5 11:20
 */
public enum MqEnum {

    DELAY_QUEUE("延时队列","delayQueue"),
    DELAY_EXCHANGE("延时交换机","delayExchange"),
    DELAY_ROUTING_KEY("业务路由键","delayRoutingKey"),
    DELAY_DEAD_LETTER_QUEUE("延时死信队列","delayDeadLetterQueue"),
    DELAY_DEAD_LETTER_EXCHANGE("延时死信交换机","delayDeadLetterExchange"),
    DELAY_DEAD_LETTER_ROUTING_KEY("延时死信路由","delayDeadLetterRoutingKey");

    public String description;

    public String name;

    MqEnum(String description, String name) {
        this.description = description;
        this.name = name;
    }
}
