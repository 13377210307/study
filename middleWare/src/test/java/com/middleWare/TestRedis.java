package com.middleWare;

import com.middleWare.redis.enums.RedisPathEnum;
import com.middleWare.redis.set.BlackList;
import com.middleWare.redis.str.ArticleReadCount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: w
 * @Date: 2021/5/28 15:10
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestRedis {

    @Autowired
    private ArticleReadCount articleReadCount;

    @Autowired
    private BlackList blackList;

    @Test
    public void testGetArticleReadCount() {
        this.articleReadCount.getArticleReadCount(1L);
    }

    @Test
    public void testIncrArticleReadCount() {
        this.articleReadCount.incrArticleReadCount(1L);
    }

    @Test
    public void testInitBlackList() {
        this.blackList.initBlackListData();
    }

    @Test
    public void testComment() {
        String comment = this.blackList.comment(3L);
        System.out.println(comment);
    }


}
