package com.middleWare;

import com.middleWare.rabbitMq.deadLetter.service.DeadLetterService;
import com.middleWare.rabbitMq.delayQueue.service.DelayOrderService;
import com.middleWare.rabbitMq.delayQueue.service.DelayRefundService;
import com.middleWare.rabbitMq.delayQueue.service.DelayService;
import com.middleWare.rabbitMq.peakClipping.service.PeakClippingService;
import com.middleWare.rabbitMq.reliable.entity.ConfirmOrder;
import com.middleWare.rabbitMq.reliable.service.OrderService;
import com.middleWare.rabbitMq.ttlMessage.service.TtlService;
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
    private DelayService delayService;

    @Autowired
    private DelayOrderService delayOrderService;

    @Autowired
    private TtlService ttlService;

    @Autowired
    private DelayRefundService delayRefundService;

    @Autowired
    private PeakClippingService peakClippingService;

    @Autowired
    private OrderService orderService;

    // 测试死信队列
    @Test
    public void testSendMsgToDeadLetter() {
        this.deadLetterService.sendMsgToDeadLetter("测试死信队列");
    }

    // 测试延时队列
    @Test
    public void testSendMsgToDelayQueue() {
        System.out.println("=====================" + new Date());
        this.delayService.sendMsg();
    }

    // 订单延时
    @Test
    public void testSendMsgToDelayOrderQueue() {
        this.delayOrderService.sendMsg();
    }

    // 单条消息ttl
    @Test
    public void testSendMsgTTl() {
        this.ttlService.sendMessageTTl();
    }

    // 队列消息ttl
    @Test
    public void testSendMsgQueueTTl() {
        this.ttlService.sendQueueTTl();
    }

    // 退款延时
    @Test
    public void testSendRefundMsg() {
        this.delayRefundService.sendMsg("张三");
    }

    // 削峰
    @Test
    public void testPeakClipping() {
        for (int i = 0; i < 1000; i++) {
            Integer count = i;
            new Thread(() -> {
                this.peakClippingService.send(count);
            }).start();
        }
        //this.peakClippingService.send();
    }

    // 消息确认
    @Test
    public void testConfirmOrder() {
        ConfirmOrder order = new ConfirmOrder();
        order.setName("订单一号");
        this.orderService.saveOrder(order);
    }
}
