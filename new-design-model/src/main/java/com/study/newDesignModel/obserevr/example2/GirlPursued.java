package com.study.newDesignModel.obserevr.example2;

import cn.hutool.core.collection.CollectionUtil;

/**
 * @Author: w
 * @Date: 2021/6/6 16:41
 */
public class GirlPursued extends Pursued {

    @Override
    void addFollower(Follower follower) {
        super.getFollowers().add(follower);
    }

    @Override
    void removeFollower(Follower follower) {
        if (CollectionUtil.isNotEmpty(super.getFollowers())) {
            super.getFollowers().remove(follower);
        }
    }

    @Override
    void notifyAllFollower() {
        if (CollectionUtil.isNotEmpty(super.getFollowers())) {
            for (Follower follower : super.getFollowers()) {
                follower.update();
            }
        }
    }
}
