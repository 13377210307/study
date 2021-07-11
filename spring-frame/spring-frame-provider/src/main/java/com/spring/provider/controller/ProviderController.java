package com.spring.provider.controller;

import com.spring.provider.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
