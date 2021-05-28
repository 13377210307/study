package com.design.strategy.example4.version5;

/**
 * @Author: w
 * @Date: 2021/5/28 10:19
 */
public class MoveQuickStrategy implements MoveStrategy {

    @Override
    public String move() {
        return "快速移动";
    }
}
