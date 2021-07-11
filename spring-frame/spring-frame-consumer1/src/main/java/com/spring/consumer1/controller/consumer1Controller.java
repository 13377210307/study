package com.spring.consumer1.controller;

import com.spring.consumer1.service.Consumer1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: w
 * @Date: 2021/7/11 15:47
 */
@RestController
@RequestMapping("consumer1")
public class consumer1Controller {

    @Autowired
    private Consumer1Service consumer1Service;

    @GetMapping
    public String consumer() {
        return this.consumer1Service.consumer();
    }
}
