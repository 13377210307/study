package com.middleWare;

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
        String a = "zs ls ww";
        String b = "zs ll ww";
        Set intersect = this.redisTemplate.opsForSet().intersect(a, b);
        System.out.println(intersect);
    }


}
