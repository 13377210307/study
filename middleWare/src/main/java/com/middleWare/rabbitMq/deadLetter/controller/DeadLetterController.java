package com.middleWare.rabbitMq.deadLetter.controller;

import com.middleWare.rabbitMq.deadLetter.service.DeadLetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: w
 * @Date: 2021/6/3 12:16
 */
@RestController
@RequestMapping("deadLetter")
public class DeadLetterController {

    @Autowired
    private DeadLetterService deadLetterService;

    @PostMapping
    public void sendToDeadLetterQueue() {
        this.deadLetterService.sendMsgToDeadLetter("测试死信队列");
    }
}
