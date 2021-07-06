package com.middleWare;

import com.middleWare.redis.set.service.CommonFriendsService;
import com.middleWare.redis.set.service.impl.BlackListServiceImpl;
import com.middleWare.redis.str.ArticleReadCount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

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


}
