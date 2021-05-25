package com.design.publishSubscribe.example1;

/**
 * @Author: w
 * @Date: 2021/5/24 17:24
 */
public class TestNews {

    public static void main(String[] args) {

        // 创建报社
        News new1 = new New1();
        new1.setName("午间新闻社");
        new1.setArticles("当代年轻人为何频频离职？？？");

        News new2 = new New2();
        new2.setName("晚间新闻社");
        new2.setArticles("揭秘为何当代年轻人频繁跳槽！！！");

        // 创建读者
        Reader reader1 = new Reader1("读者1号", new1);
        Reader reader2 = new Reader2("读者2号", new2);

        // 读者关注
        new1.addReader(reader1);
        new2.addReader(reader2);

        // 通知读者
        reader1.updateData();
        //reader2.updateData();
    }
}
