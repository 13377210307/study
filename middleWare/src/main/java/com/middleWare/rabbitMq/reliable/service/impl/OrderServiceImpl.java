package com.middleWare.rabbitMq.reliable.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.middleWare.rabbitMq.reliable.entity.BrokerMessageLog;
import com.middleWare.rabbitMq.reliable.entity.ConfirmOrder;
import com.middleWare.rabbitMq.reliable.enums.MqEnum;
import com.middleWare.rabbitMq.reliable.mapper.OrderMapper;
import com.middleWare.rabbitMq.reliable.service.BrokeMessageLogService;
import com.middleWare.rabbitMq.reliable.service.OrderService;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: w
 * @Date: 2021/6/18 15:31
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, ConfirmOrder> implements OrderService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private BrokeMessageLogService brokeMessageLogService;

    @Override
    public Integer saveOrder(ConfirmOrder order) {
        int result = this.baseMapper.insert(order);
        BrokerMessageLog brokerMessageLog = new BrokerMessageLog();
        brokerMessageLog.setOrderId(order.getId());
        // 新增日志
        this.brokeMessageLogService.saveBrokerMessageLog(brokerMessageLog);
        CorrelationData correlationData = new CorrelationData(brokerMessageLog.getMessageId().toString());
        this.rabbitTemplate.convertAndSend("aaa",MqEnum.ORDER_CONFIRM_ROUTING_KEY.name,brokerMessageLog.getMessageId(),correlationData);
        return result;
    }
}
