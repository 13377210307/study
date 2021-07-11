package com.spring.consumer1.service.impl;

import com.spring.consumer1.service.Consumer1Service;
import org.springframework.stereotype.Service;

/**
 * @Author: w
 * @Date: 2021/7/11 15:50
 */
@Service
public class Consumer1ServiceImpl implements Consumer1Service {


    @Override
    public String consumer() {
        return "消费方获取到的消息...";
    }
}
