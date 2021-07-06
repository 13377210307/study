package com.middleWare.redis.set.service;

/**
 * @Author: w
 * @Date: 2021/7/1 8:51
 */
public interface BlackListService {

    // 添加黑名单
    void addBlackList(Long userId);

    // 移除黑名单
    void removeBlackList(Long userId);

    // 评论
    String comment(Long userId);
}
