package com.design.publishSubscribe.example2;

import lombok.Data;

import java.util.List;

/**
 * @Author: w
 * @Date: 2021/5/24 17:38
 * 抽象读者类
 */
@Data
public abstract class Reader {

    // 姓名
    private String name;

    // 报社
    private News news;

    // 获取推送文章方法
    public abstract void getPublishArticles();

}
