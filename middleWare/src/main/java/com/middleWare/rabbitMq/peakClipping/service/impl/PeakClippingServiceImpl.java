package com.middleWare.rabbitMq.peakClipping.service.impl;

import com.middleWare.rabbitMq.peakClipping.service.PeakClippingService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Author: w
 * @Date: 2021/6/18 9:07
 * 发送消息
 */
@Service
public class PeakClippingServiceImpl implements PeakClippingService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void send(Integer num) {
        this.rabbitTemplate.convertAndSend("peakExchange","peakRoutingKey","测试削峰..." + num);
    }
}
