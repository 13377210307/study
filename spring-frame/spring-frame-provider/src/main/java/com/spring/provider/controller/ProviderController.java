package com.spring.provider.controller;

import com.spring.provider.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author: w
 * @Date: 2021/7/11 15:23
 */
@RestController
@RequestMapping("provider")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @GetMapping
    public String provider() {
        return this.providerService.provider();
    }

    @GetMapping("/timeout")
    public String providerTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "生产方提供接口信息...";
    }
}
