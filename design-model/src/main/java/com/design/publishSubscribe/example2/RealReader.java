package com.design.publishSubscribe.example2;

import lombok.Data;

/**
 * @Author: w
 * @Date: 2021/5/24 17:43
 */
@Data
public class RealReader extends Reader {

    private String name;

    private News news;

    public RealReader(String name, News news) {
        this.name = name;
        this.news = news;
    }

    @Override
    public void getPublishArticles() {
        System.out.println("亲爱的" + this.name + "：您关注的" + news.getName() + "发布了一篇新的文章：" + news.getArticles());
    }
}
