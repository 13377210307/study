package com.middleWare.redis.enums;

/**
 * @Author: w
 * @Date: 2021/5/28 15:02
 */
public enum RedisPathEnum {

    ARTICLE("文章阅读量","study:str:article:"),
    BLACK_LIST("黑名单","study:set:blackList"),
    COMMON_FRIENDS("共同好友","study:set:commonFriends:"),
    TIME_OUT("过期监控","study:str:timeout:");

    public String description;

    public String path;

    RedisPathEnum(String description, String path) {
        this.description = description;
        this.path = path;
    }
}
