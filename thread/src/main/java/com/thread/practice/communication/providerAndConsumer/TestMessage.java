package com.thread.practice.communication.providerAndConsumer;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * @Author: w
 * @Date: 2021/7/15 8:53
 */
public class TestMessage {

    public static void main(String[] args) {
        // 消息队列
        MessageQueue messageQueue = new MessageQueue();
        LinkedList<Message> messages = new LinkedList<>();
        messageQueue.setMessages(messages);
        messageQueue.setCapcity(10);
        // 消息生产者
        MessageProvider messageProvider = new MessageProvider(messageQueue);
        // 消息消费者
        MessageConsumer messageConsumer = new MessageConsumer(messageQueue);

        // 生产消息
        for (int i = 0; i < 5; i++) {
            Integer count = i;
            new Thread(() -> {
                Message message = new Message();
                message.setId(count.toString());
                message.setName("信息" + count + "号");
                messageProvider.putMessage(message);
            },"生产者" + count + "号").start();
        }

        // 消费消息
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (true) {
                messageConsumer.takeMessage();
            }
        },"消费者").start();
    }
}
