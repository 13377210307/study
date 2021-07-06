package com.middleWare.redis.set.service;

import java.util.List;

/**
 * @Author: w
 * @Date: 2021/7/1 8:49
 * 共同好友
 */
public interface CommonFriendsService {

    List<String> getCommonFriends(Long userId1,Long userId2);

    void initFriendsList(Long userId, List<Long> friendIds);

}
