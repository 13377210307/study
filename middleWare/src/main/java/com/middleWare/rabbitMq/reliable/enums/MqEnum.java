package com.middleWare.rabbitMq.reliable.enums;

/**
 * @Author: w
 * @Date: 2021/6/18 14:53
 */
public enum MqEnum {

    ORDER_CONFIRM_QUEUE("订单队列","orderConfirmQueue"),
    ORDER_CONFIRM_EXCHANGE("订单交换机","orderConfirmExchange"),
    ORDER_CONFIRM_ROUTING_KEY("订单路由键","orderConfirmRoutingKey");

    public String description;

    public String name;

    MqEnum(String description, String name) {
        this.description = description;
        this.name = name;
    }
}
