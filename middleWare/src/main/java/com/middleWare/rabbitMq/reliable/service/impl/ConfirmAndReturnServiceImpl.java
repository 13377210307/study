package com.middleWare.rabbitMq.reliable.service.impl;

import com.middleWare.rabbitMq.reliable.mapper.BrokerMessageLogMapper;
import com.middleWare.rabbitMq.reliable.service.BrokeMessageLogService;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;

/**
 * @Author: w
 * @Date: 2021/6/18 15:44
 */
@Service
public class ConfirmAndReturnServiceImpl implements RabbitTemplate.ConfirmCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private BrokeMessageLogService brokeMessageLogService;

    @PostConstruct
    public void init() {
        //设置 ConfirmCallback
        this.rabbitTemplate.setConfirmCallback(this);
    }

    /**
     * 如果消息没有到达交换机,则该方法中isSendSuccess = false,error为错误信息;
     * 如果消息正确到达交换机,则该方法中isSendSuccess = true;
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean isSendSuccess, String s) {
        Long messageId = Long.parseLong(correlationData.getId());
        if (isSendSuccess) {
            //如果消息到达MQ Broker，更新消息
            brokeMessageLogService.changeBrokerMessageLogStatus(messageId, 1);
        } else {
            System.out.println("消息发送异常...");
        }
    }
}
