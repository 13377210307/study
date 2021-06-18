package com.middleWare.rabbitMq.peakClipping.enums;

/**
 * @Author: w
 * @Date: 2021/6/5 11:20
 */
public enum MqEnum {

    PEAK_QUEUE("削峰队列","peakQueue"),
    PEAK_EXCHANGE("削峰交换机","peakExchange"),
    PEAK_ROUTING_KEY("削峰路由键","peakRoutingKey");

    public String description;

    public String name;

    MqEnum(String description, String name) {
        this.description = description;
        this.name = name;
    }
}
