package com.middleWare.rabbitMq.delayQueue.controller;

import com.middleWare.rabbitMq.delayQueue.service.DelayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: w
 * @Date: 2021/6/5 13:04
 */
@RestController
@RequestMapping("delay")
public class DelayController {

    @Autowired
    private DelayService delayService;

    @GetMapping
    public void test1() {
       this.delayService.sendMsg();
    }
}
