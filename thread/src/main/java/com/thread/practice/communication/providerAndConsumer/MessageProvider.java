package com.thread.practice.communication.providerAndConsumer;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: w
 * @Date: 2021/7/15 8:34
 */
@Slf4j
public class MessageProvider {

    private MessageQueue messageQueue;

    public MessageProvider(MessageQueue messageQueue) {
        this.messageQueue = messageQueue;
    }

    // 放入消息
    public void putMessage(Message message) {
        synchronized (messageQueue) {
            while (messageQueue.getCapcity() == messageQueue.getMessages().size()) {
                // 生产者停止生产
                try {
                    messageQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.debug("信箱已经满了，请稍候生产...");
            }
            // 信箱未满，进行生产并且唤醒消费者进行消费
            // 生产
            log.debug("开始生产信息...");
            messageQueue.getMessages().addLast(message);
            // 唤醒消费者进行消费
            messageQueue.notifyAll();
        }
    }
}
