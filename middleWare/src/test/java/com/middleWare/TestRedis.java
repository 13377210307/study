package com.middleWare;

import com.middleWare.redis.enums.RedisPathEnum;
import com.middleWare.redis.set.service.CommonFriendsService;
import com.middleWare.redis.set.service.impl.BlackListServiceImpl;
import com.middleWare.redis.str.ArticleReadCount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

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
    private BlackListServiceImpl blackList;

    @Autowired
    private CommonFriendsService commonFriendsService;

    @Autowired
    private RedisTemplate redisTemplate;

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

    @Test
    public void testInitFriends() {
        List<Long> friends = Arrays.asList(5L,6L);
        this.commonFriendsService.initFriendsList(4L,friends);
    }

    @Test
    public void testGetCommonFriends() {
        List<String> commonFriends = this.commonFriendsService.getCommonFriends(1L, 4L);
        System.out.println("");
    }

    @Test
    public void test1() {
        // 设置守护线程监控即将过期的键
        this.redisTemplate.opsForValue().set(RedisPathEnum.TIME_OUT.path,"过期值1", 30L,TimeUnit.SECONDS);

        Long expire = this.redisTemplate.getExpire(RedisPathEnum.TIME_OUT.path);
        while (expire <= 10) {
            this.redisTemplate.expire(RedisPathEnum.TIME_OUT.path, 30L, TimeUnit.SECONDS);
        }
        Thread thread = new Thread(() -> {
            System.out.println("该键还有" + expire + "秒过期...");
        });
        thread.setDaemon(true);
        thread.start();
    }

    private Long getTimeOut(ExecutorService pool,String key) {
        Future<Long> timeoutFuture = pool.submit(() -> {
            return this.redisTemplate.getExpire(key);
        });
        Long timeout = 0L;
        try {
            timeout = timeoutFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return timeout;
    }


}
