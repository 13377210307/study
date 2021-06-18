package com.middleWare.rabbitMq.reliable.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.middleWare.rabbitMq.reliable.entity.BrokerMessageLog;
import org.springframework.amqp.core.Message;

/**
 * @Author: w
 * @Date: 2021/6/18 15:33
 */
public interface BrokeMessageLogService extends IService<BrokerMessageLog> {

    Integer saveBrokerMessageLog(BrokerMessageLog brokerMessageLog);

    Integer changeBrokerMessageLogStatus(Long messageId,Integer status);
}
