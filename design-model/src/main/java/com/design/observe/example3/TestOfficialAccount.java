package com.design.observe.example3;

/**
 * @Author: w
 * @Date: 2021/5/28 11:51
 */
public class TestOfficialAccount {

    public static void main(String[] args) {

        // 创建微信公众号
        OfficialAccount wechatOfficialAccount = new WechatOfficialAccount();
        wechatOfficialAccount.setName("咿呀呀呀");

        // 创建微信用户
        WechatUser wechatUser1 = new WechatUser();
        wechatUser1.setName("西门吹雪");
        wechatUser1.setOfficialAccount(wechatOfficialAccount);

        WechatUser wechatUser2 = new WechatUser();
        wechatUser2.setName("东门吹风");
        wechatUser2.setOfficialAccount(wechatOfficialAccount);

        // 微信用户关注微信公众号
        wechatOfficialAccount.addObserver(wechatUser1);
        wechatOfficialAccount.addObserver(wechatUser2);

        wechatOfficialAccount.setArticle("这就很难受了呀...");

        // 通知
        wechatOfficialAccount.notifyAllObserver();

    }
}
