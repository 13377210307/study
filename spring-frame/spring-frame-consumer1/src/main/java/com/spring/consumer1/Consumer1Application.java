package com.spring.consumer1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: w
 * @Date: 2021/7/11 15:43
 */
@SpringBootApplication
@EnableFeignClients
public class Consumer1Application {

    public static void main(String[] args) {
        SpringApplication.run(Consumer1Application.class);
    }
}
