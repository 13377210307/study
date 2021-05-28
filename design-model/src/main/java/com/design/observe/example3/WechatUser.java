package com.design.observe.example3;

import lombok.Data;

/**
 * @Author: w
 * @Date: 2021/5/28 11:38
 */
@Data
public class WechatUser implements OfficialAccountObserver {

    private String name;

    private OfficialAccount officialAccount;

    @Override
    public void updateData() {
        System.out.println(name + "，" + "您关注的公众号：" + officialAccount.getName() + "刚发布了一篇新文章："+officialAccount.getArticle());
    }
}
