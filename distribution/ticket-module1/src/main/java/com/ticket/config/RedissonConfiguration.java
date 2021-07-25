package com.ticket.config;

import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Author: w
 * @Date: 2021/7/18 11:44
 */
@Configuration
public class RedissonConfiguration {

    @Bean(name = "redisson")
    public Redisson redisson() {

        // 设置主从或单机
        Config config = new Config();
        // 服务器
        config.useSingleServer().setAddress("redis://39.105.59.91:6379").setPassword("wen").setDatabase(0);
        // 本机
        //config.useSingleServer().setAddress("redis://127.0.0.1:6379").setDatabase(3);
        return (Redisson)Redisson.create(config);
    }

}
