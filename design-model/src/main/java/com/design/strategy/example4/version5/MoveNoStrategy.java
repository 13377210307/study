package com.design.strategy.example4.version5;

/**
 * @Author: w
 * @Date: 2021/5/28 10:38
 */
public class MoveNoStrategy implements MoveStrategy {

    @Override
    public String move() {
        return "无法移动";
    }
}
