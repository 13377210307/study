package com.middleWare.redis.set.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.middleWare.redis.enums.RedisPathEnum;
import com.middleWare.redis.set.service.BlackListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author: w
 * @Date: 2021/6/16 8:50
 * 采用redis中的set做为评论黑名单
 */
@Service
public class BlackListServiceImpl implements BlackListService {

    @Autowired
    private RedisTemplate redisTemplate;

    // 添加黑名单
    @Override
    public void addBlackList(Long userId) {
        this.redisTemplate.opsForSet().add(RedisPathEnum.BLACK_LIST.path,userId);
    }

    // 移除黑名单
    @Override
    public void removeBlackList(Long userId) {
        this.redisTemplate.opsForSet().remove(RedisPathEnum.BLACK_LIST.path,userId);
    }

    // 评论
    @Override
    public String comment(Long userId) {
        // 获取存放在redis的黑名单列表
        Boolean member = this.redisTemplate.opsForSet().isMember(RedisPathEnum.BLACK_LIST.path, userId);
        if (member) {
            return "您在评论黑名单中，所以不能进行评论";
        }else {
            return "评论成功";
        }
    }

    // 初始化黑名单列表
    public void initBlackListData() {
        // 获取黑名单列表
        List<Long> blackListDatas = this.getBlackListData();
        if (CollectionUtil.isNotEmpty(blackListDatas)) {
            for (Long blackListData : blackListDatas) {
                this.redisTemplate.opsForSet().add(RedisPathEnum.BLACK_LIST.path,blackListData);
            }
        }
    }

    // 获取黑名单数据
    private List<Long> getBlackListData() {
        List<Long> userIds = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            Integer userId = random.nextInt(100) + 1;
            userIds.add(Long.valueOf(userId));
        }
       return userIds;
    }

}
