package com.study.newDesignModel.obserevr.example2;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: w
 * @Date: 2021/6/6 16:37
 * 被追求者
 */
@Data
public abstract class Pursued {

    // 名称
    private String name;

    // 状态：1：开心  2：伤心
    private Integer status;

    private List<Follower> followers = new ArrayList<>();

    // 增加追求者
    abstract void addFollower(Follower follower);

    // 移除追求者
    abstract void removeFollower(Follower follower);

    // 通知所有追求者
    abstract void notifyAllFollower();

}
