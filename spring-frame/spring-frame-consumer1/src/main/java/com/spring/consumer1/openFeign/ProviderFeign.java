package com.spring.consumer1.openFeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: w
 * @Date: 2021/7/12 8:56
 */
@Component
@FeignClient("PROVIDER")
public interface ProviderFeign {

    @GetMapping("/provider")
    String provider();

    @GetMapping("/provider/timeout")
    String providerTimeout();
}
