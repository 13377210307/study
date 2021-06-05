package com.middleWare;

import com.middleWare.rabbitMq.deadLetter.service.DeadLetterService;
import com.middleWare.rabbitMq.delayQueue.service.SendMsgService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @Author: w
 * @Date: 2021/6/3 14:03
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestMq {

    @Autowired
    private DeadLetterService deadLetterService;

    @Autowired
    private SendMsgService sendMsgService;

    @Test
    public void testSendMsgToDeadLetter() {
        this.deadLetterService.sendMsgToDeadLetter("测试死信队列");
    }

    @Test
    public void testSendMsgToDelayQueue() {
        System.out.println("=====================" + new Date());
        this.sendMsgService.sendMsg();
    }
}
