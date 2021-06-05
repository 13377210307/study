package com.middleWare.rabbitMq.deadLetter.enums;

/**
 * @Author: w
 * @Date: 2021/6/3 11:29
 */
public enum MqEnum {

    BUSINESS_QUEUE("业务队列","businessQueue"),
    BUSINESS_EXCHANGE("业务交换机","businessExchange"),
    BUSINESS_ROUTING_KEY("业务路由键","businessRoutingKey"),
    DEAD_LETTER_QUEUE("死信队列","deadLetterQueue"),
    DEAD_LETTER_EXCHANGE("死信交换机","deadLetterExchange"),
    DEAD_LETTER_ROUTING_KEY("死信路由","deadLetterRoutingKey");

    public String description;

    public String name;

    MqEnum(String description, String name) {
        this.description = description;
        this.name = name;
    }
}
