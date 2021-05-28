package com.design.strategy.example4.version5;

/**
 * @Author: w
 * @Date: 2021/5/28 10:16
 * 正常移动
 */
public class MoveNormalStrategy implements MoveStrategy {

    @Override
    public String move() {
        return "正常移动";
    }
}
