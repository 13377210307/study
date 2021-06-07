package com.study.newDesignModel.obserevr.example2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: w
 * @Date: 2021/6/6 16:49
 */
public class TestFollower {

    public static void main(String[] args) {

        // 创建被追求者
        Pursued girlPursued = new GirlPursued();
        girlPursued.setName("如花");
        girlPursued.setStatus(2);

        List<Follower> followers = new ArrayList<>();

        // 创建追求者
        Follower boyFollower1 = new BoyFollower(girlPursued);
        boyFollower1.setName("张三");
        followers.add(boyFollower1);
        Follower boyFollower2 = new BoyFollower(girlPursued);
        boyFollower2.setName("李四");
        followers.add(boyFollower2);

        // 新增追求者
        girlPursued.setFollowers(followers);
        // 通知
        girlPursued.notifyAllFollower();

    }
}
