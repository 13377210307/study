package com.study.newDesignModel.obserevr.example2;

/**
 * @Author: w
 * @Date: 2021/6/6 16:36
 * 男性追求者
 */
public class BoyFollower extends Follower {

    private Pursued pursued;

    public BoyFollower(Pursued pursued) {
        this.pursued = pursued;
    }

    @Override
    void update() {
        if (1 == pursued.getStatus()) {
            System.out.println(super.getName() + "：" + pursued.getName() +"看你今晚这么开心，一起出去看个电影吧");
        }
        if (2 == pursued.getStatus()) {
            System.out.println(super.getName() + "：" + pursued.getName() +"不哭不哭，那个渣男不知道你为他流泪");
        }
    }
}
