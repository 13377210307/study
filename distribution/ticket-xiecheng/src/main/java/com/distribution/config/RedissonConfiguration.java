package com.distribution.config;

import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: w
 * @Date: 2021/7/18 11:44
 */
@Configuration
public class RedissonConfiguration {

    @Bean(name = "redisson",destroyMethod = "shutdown")
    public Redisson redisson() {

        // 设置主从或单机
        Config config = new Config();
        // 监控锁的看门狗超时(默认30秒)，单位：毫秒
        config.setLockWatchdogTimeout(60000);
        // 服务器
        config.useSingleServer().setAddress("redis://39.105.59.91:6379").setPassword("wen").setDatabase(0);
        // 本机
        //config.useSingleServer().setAddress("redis://127.0.0.1:6379").setDatabase(3);
        return (Redisson)Redisson.create(config);
    }

}
