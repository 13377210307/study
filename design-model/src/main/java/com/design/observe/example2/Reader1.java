package com.design.observe.example2;

/**
 * @Author: w
 * @Date: 2021/5/23 18:54
 */
public class Reader1 implements ReaderObserver {

    // 关注的报社
    private NewsStation newsStation;

    // 通过构造方法传入

    public Reader1(NewsStation newsStation) {
        this.newsStation = newsStation;
    }

    @Override
    public void getArticle() {
        System.out.println("亲爱的读者1号：" + newsStation.getName() + "：刚刚发布了一篇文章：" + newsStation.getArticle());
    }
}
