package com.thread.practice.communication.providerAndConsumer;

import cn.hutool.core.collection.CollectionUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: w
 * @Date: 2021/7/15 8:48
 */
@Slf4j
public class MessageConsumer {

    private MessageQueue messageQueue;

    public MessageConsumer(MessageQueue messageQueue) {
        this.messageQueue = messageQueue;
    }

    // 消费消息
    public void takeMessage() {
        synchronized (messageQueue) {
            while (CollectionUtil.isEmpty(messageQueue.getMessages())) {
                // 停止消费
                try {
                    messageQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 进行消费
            log.debug("消费消息为：{}",messageQueue.getMessages().getFirst());
            messageQueue.getMessages().removeFirst();
            // 唤醒生产
            messageQueue.notifyAll();
        }
    }
}
