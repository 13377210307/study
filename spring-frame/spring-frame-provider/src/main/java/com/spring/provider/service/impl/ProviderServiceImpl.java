package com.spring.provider.service.impl;

import com.spring.provider.service.ProviderService;
import org.springframework.stereotype.Service;

/**
 * @Author: w
 * @Date: 2021/7/11 15:24
 */
@Service
public class ProviderServiceImpl implements ProviderService {


    @Override
    public String provider() {
        return "生产方提供接口信息...";
    }
}
