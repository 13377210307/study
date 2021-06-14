package com.middleWare.rabbitMq.delayQueue.service.impl;

import com.middleWare.rabbitMq.delayQueue.enums.MqEnum;
import com.middleWare.rabbitMq.delayQueue.service.DelayRefundService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: w
 * @Date: 2021/6/7 8:59
 */
@Service
public class DelayRefundServiceImpl implements DelayRefundService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendMsg(String consumer) {
        this.rabbitTemplate.convertAndSend(MqEnum.DELAY_REFUND_ORDER_EXCHANGE.name,MqEnum.DELAY_REFUND_ORDER_ROUTING_KEY.name,"客户：" + consumer + "的退款申请已经三天未受理了，请您尽快处理");
 }
}
