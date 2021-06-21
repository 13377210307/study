package com.thread.communication;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * @Author: w
 * @Date: 2021/6/19 10:40
 */
@Slf4j
public class ProviderAndConsumer {

    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue(2);
        // 创建生产者线程
        for (int i = 0; i < 3; i++) {
            int id = i;
            new Thread(() -> {
                messageQueue.put(new Message(id, "消息" + id));
            },"生产者" + id).start();
        }


        // 创建消费者
        new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Message take = messageQueue.take();
                log.debug("获得消息为，{}",take);
            }
        },"消费者").start();
    }
}

// 消息队列类，java线程之间通信
@Slf4j
class MessageQueue{

    // 消息队列集合
    private LinkedList<Message> list = new LinkedList<>();

    // 队列容量
    private int capcity;

    public MessageQueue(int capcity) {
        this.capcity = capcity;
    }

    // 获取消息
    public Message take() {
        synchronized (list) {
            // 检查队列是否为空
            while (list.isEmpty()) {
                log.debug("队列为空，消费者线程等待...");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 从队列的头部获取消息并返回
            Message message = list.removeFirst();
            log.debug("消费消息，{}",message.getValue());
            // 唤醒生产者
            list.notifyAll();
            return message;

        }
    }

    // 存入消息
    public void put(Message message) {
        synchronized (list) {
            // 检查对立是否满了
            while (list.size() == capcity) {
                log.debug("队列已满，生产者线程等待...");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            log.debug("生产消息，{}",message.getValue());
            // 将消息加入尾部
            list.addLast(message);
            // 唤醒消费者进行消费
            list.notifyAll();
        }

    }
}

@Data
class Message {

    private int id;

    private Object value;

    public Message(int id, Object value) {
        this.id = id;
        this.value = value;
    }
}
