package com.middleWare;

import com.middleWare.rabbitMq.service.DeadLetterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: w
 * @Date: 2021/6/3 14:03
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestMq {

    @Autowired
    private DeadLetterService deadLetterService;

    @Test
    public void testSendMsgToDeadLetter() {
        this.deadLetterService.sendMsgToDeadLetter("测试死信队列");
    }
}
