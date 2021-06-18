package com.middleWare.rabbitMq.reliable.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.middleWare.rabbitMq.reliable.entity.BrokerMessageLog;
import com.middleWare.rabbitMq.reliable.mapper.BrokerMessageLogMapper;
import com.middleWare.rabbitMq.reliable.service.BrokeMessageLogService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author: w
 * @Date: 2021/6/18 15:34
 */
@Service
public class BrokeMessageLogServiceImpl extends ServiceImpl<BrokerMessageLogMapper, BrokerMessageLog> implements BrokeMessageLogService {


    public Integer saveBrokerMessageLog(BrokerMessageLog brokerMessageLog) {
        brokerMessageLog.setCreateTime(new Date());
        brokerMessageLog.setUpdateTime(new Date());
        brokerMessageLog.setStatus(0);
        brokerMessageLog.setTryCount(0);
        return this.baseMapper.insert(brokerMessageLog);
    }

    @Override
    public Integer changeBrokerMessageLogStatus(Long messageId,Integer status) {
        BrokerMessageLog brokerMessageLog = this.baseMapper.selectById(messageId);
        brokerMessageLog.setStatus(status);
        return this.baseMapper.updateById(brokerMessageLog);
    }
}
