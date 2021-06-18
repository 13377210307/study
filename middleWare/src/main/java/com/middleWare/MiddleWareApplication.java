package com.middleWare;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: w
 * @Date: 2021/5/28 14:49
 */
@SpringBootApplication
@MapperScan("com.middleWare.rabbitMq.reliable.mapper")
public class MiddleWareApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiddleWareApplication.class);
    }
}
