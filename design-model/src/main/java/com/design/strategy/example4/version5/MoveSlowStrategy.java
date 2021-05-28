package com.design.strategy.example4.version5;

/**
 * @Author: w
 * @Date: 2021/5/28 10:18
 */
public class MoveSlowStrategy implements MoveStrategy {

    @Override
    public String move() {
        return "缓慢移动";
    }
}
