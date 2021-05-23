package com.design.observe.example2;

/**
 * @Author: w
 * @Date: 2021/5/23 18:56
 */
public class Reader2 implements ReaderObserver {

    // 关注的报社
    private NewsStation newsStation;

    // 通过构造方法传入

    public Reader2(NewsStation newsStation) {
        this.newsStation = newsStation;
    }

    @Override
    public void getArticle() {
        System.out.println("亲爱的读者2号：" + newsStation.getName() + "：刚刚发布了一篇文章：" + newsStation.getArticle());
    }
}
