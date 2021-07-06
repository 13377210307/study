package com.middleWare.redis.set.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.middleWare.redis.enums.RedisPathEnum;
import com.middleWare.redis.set.service.CommonFriendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author: w
 * @Date: 2021/7/1 8:56
 */
@Service
public class CommonFriendsServiceImpl implements CommonFriendsService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<String> getCommonFriends(Long userId1, Long userId2) {
        Set members1 = this.redisTemplate.opsForSet().members(RedisPathEnum.COMMON_FRIENDS.path + userId1);
        Set members2 = this.redisTemplate.opsForSet().members(RedisPathEnum.COMMON_FRIENDS.path + userId2);
        Set<Long> commonFriends = this.redisTemplate.opsForSet().intersect(members1, members2);
        return this.getFriendName(commonFriends);
    }

    // 初始化好友集合
    @Override
    public void initFriendsList(Long userId, List<Long> friendIds) {
        if (CollectionUtil.isNotEmpty(friendIds)) {
            for (Long friendId : friendIds) {
                this.redisTemplate.opsForSet().add(RedisPathEnum.COMMON_FRIENDS.path + userId,friendId);
            }
        }
    }

    // 获取好友名称
    private List<String> getFriendName(Set<Long> userIds) {
        List<String> usernames = new ArrayList<>();
        Map<Long,String> maps = new HashMap<>();
        maps.put(1L,"zs");
        maps.put(2L,"ls");
        maps.put(3L,"ww");
        maps.put(4L,"ll");
        maps.put(5L,"tq");
        maps.put(6L,"zb");

        if (CollectionUtil.isNotEmpty(userIds)) {
            for (Long userId : userIds) {
                usernames.add(maps.get(userId));
            }
        }
        return usernames;
    }


}
