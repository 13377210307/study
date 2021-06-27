package com.middleWare.rabbitMq.delayQueue.enums;

/**
 * @Author: w
 * @Date: 2021/6/5 11:20
 */
public enum MqEnum {

    DELAY_QUEUE("延时队列","delayQueue"),
    DELAY_EXCHANGE("延时交换机","delayExchange"),
    DELAY_ROUTING_KEY("延时路由键","delayRoutingKey"),
    DELAY_DEAD_LETTER_QUEUE("延时死信队列","delayDeadLetterQueue"),
    DELAY_DEAD_LETTER_EXCHANGE("延时死信交换机","delayDeadLetterExchange"),
    DELAY_DEAD_LETTER_ROUTING_KEY("延时死信路由","delayDeadLetterRoutingKey"),
    DELAY_ORDER_QUEUE("延时订单队列","delayOrderQueue"),
    DELAY_ORDER_EXCHANGE("延时订单交换机","delayOrderExchange"),
    DELAY_ORDER_ROUTING_KEY("延时订单路由键","delayOrderRoutingKey"),
    DELAY_ORDER_DEAD_LETTER_QUEUE("延时订单死信队列","delayOrderDeadLetterQueue"),
    DELAY_ORDER_DEAD_LETTER_EXCHANGE("延时订单死信交换机","delayOrderDeadLetterExchange"),
    DELAY_ORDER_DEAD_LETTER_ROUTING_KEY("延时订单死信路由","delayOrderDeadLetterRoutingKey"),
    DELAY_REFUND_ORDER_QUEUE("延时退款队列","delayRefundOrderQueue"),
    DELAY_REFUND_ORDER_EXCHANGE("延时退款交换机","delayRefundOrderExchange"),
    DELAY_REFUND_ORDER_ROUTING_KEY("延时退款路由键","delayRefundOrderRoutingKey"),
    DELAY_REFUND_ORDER_DEAD_LETTER_QUEUE("延时退款死信队列","delayRefundOrderDeadLetterQueue"),
    DELAY_REFUND_ORDER_DEAD_LETTER_EXCHANGE("延时退款死信交换机","delayRefundOrderDeadLetterExchange"),
    DELAY_REFUND_ORDER_DEAD_LETTER_ROUTING_KEY("延时退款死信路由","delayRefundOrderDeadLetterRoutingKey"),
    DELAY_PAY_QUEUE("延时支付队列","delayPayQueue"),
    DELAY_PAY_EXCHANGE("延时支付交换机","delayPayExchange"),
    DELAY_PAY_ROUTING_KEY("延时支付路由键","delayPayRoutingKey"),
    DELAY_PAY_DEAD_LETTER_QUEUE("延时支付死信队列","delayPayDeadLetterQueue"),
    DELAY_PAY_DEAD_LETTER_EXCHANGE("延时支付死信交换机","delayPayDeadLetterExchange"),
    DELAY_PAY_DEAD_LETTER_ROUTING_KEY("延时支付死信路由","delayPayDeadLetterRoutingKey");

    public String description;

    public String name;

    MqEnum(String description, String name) {
        this.description = description;
        this.name = name;
    }
}
