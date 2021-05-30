package com.middleWare.redis.str;

import com.middleWare.redis.enums.RedisPathEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @Author: w
 * @Date: 2021/5/28 14:59
 * 通过String类型数据统计文章阅读量
 */
@Component
public class ArticleReadCount {

    @Autowired
    private StringRedisTemplate redisTemplate;

    // 方法一：获取某文章的阅读量
    public void getArticleReadCount(Long articleId) {
        String count = this.redisTemplate.opsForValue().get(RedisPathEnum.ARTICLE.path + articleId);
        System.out.println(count);
    }

    // 方法二：增加某文章的阅读量
    public void incrArticleReadCount(Long articleId) {
        this.redisTemplate.opsForValue().increment(RedisPathEnum.ARTICLE.path + articleId);
    }
}
