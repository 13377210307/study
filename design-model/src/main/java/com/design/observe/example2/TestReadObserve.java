package com.design.observe.example2;

/**
 * @Author: w
 * @Date: 2021/5/23 19:01
 */
public class TestReadObserve {

    public static void main(String[] args) {

        // 创建报社
        NewsStation newsStation = new NewsStation();
        newsStation.setName("午间新闻报社");
        newsStation.setArticle("为何当代年轻人频频跳槽？？");

        // 创建读者
        ReaderObserver reader1 = new Reader1(newsStation);
        ReaderObserver reader2 = new Reader2(newsStation);

        // 读者关注报社
        newsStation.addReader(reader1);
        newsStation.addReader(reader2);

        // 报社通知读者有文章
        newsStation.notifyAllReaders();
    }
}
