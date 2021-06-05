package com.middleWare.rabbitMq.delayQueue.controller;

import com.middleWare.rabbitMq.delayQueue.service.DelayOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: w
 * @Date: 2021/6/5 18:11
 */
@RestController
@RequestMapping("delayOrder")
public class DelayOrderController {

    @Autowired
    private DelayOrderService delayOrderService;

    @GetMapping
    public void delayOrder() {
        this.delayOrderService.sendMsg();
    }
}
