package com.study.newDesignModel.obserevr.example2;

import lombok.Data;

/**
 * @Author: w
 * @Date: 2021/6/6 16:34
 * 追求者
 */
@Data
public abstract class Follower {

    private String name;

    abstract void update();

}
