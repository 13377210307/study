package com.middleWare.rabbitMq.ttlMessage.enums;

/**
 * @Author: w
 * @Date: 2021/6/6 10:04
 */
public enum MqEnum {

    TTL_MESSAGE_QUEUE("ttl消息队列","ttlMessageQueue"),
    TTL_MESSAGE_EXCHANGE("ttl消息交换机","ttlMessageExchange"),
    TTL_MESSAGE_ROUTING_KEY("ttl消息路由键","ttlMessageRoutingKey"),
    TTL_QUEUE_QUEUE("ttl队列队列","ttlQueueQueue"),
    TTL_QUEUE_EXCHANGE("ttl队列交换机","ttlQueueExchange"),
    TTL_QUEUE_ROUTING_KEY("ttl队列路由键","ttlQueueRoutingKey");

    public String description;

    public String name;

    MqEnum(String description, String name) {
        this.description = description;
        this.name = name;
    }
}
