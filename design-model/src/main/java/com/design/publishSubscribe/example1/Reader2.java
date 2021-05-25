package com.design.publishSubscribe.example1;

/**
 * @Author: w
 * @Date: 2021/5/24 16:57
 */
public class Reader2 implements Reader {

    // 姓名
    private String name;

    // 报社
    private News news;

    public Reader2(String name,News news) {
        this.name = name;
        this.news = news;
    }

    @Override
    public void updateData() {
        System.out.println("亲爱的" + name + "：您关注的" + news.getName() + "发布了一篇新的文章：" + news.getArticles());
    }
}
