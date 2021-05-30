package com.middleWare.redis.enums;

/**
 * @Author: w
 * @Date: 2021/5/28 15:02
 */
public enum RedisPathEnum {

    ARTICLE("文章阅读量","study:str:article:");

    public String description;

    public String path;

    RedisPathEnum(String description, String path) {
        this.description = description;
        this.path = path;
    }
}
