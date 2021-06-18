package com.middleWare.rabbitMq.reliable.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.middleWare.rabbitMq.reliable.entity.ConfirmOrder;

/**
 * @Author: w
 * @Date: 2021/6/18 15:30
 */
public interface OrderService extends IService<ConfirmOrder> {

    Integer saveOrder(ConfirmOrder order);
}
