package com.middleWare.rabbitMq.deadLetter.service;

/**
 * @Author: w
 * @Date: 2021/6/3 12:17
 */
public interface DeadLetterService {

    void sendMsgToDeadLetter(String msg);

}
