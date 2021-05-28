package com.design.strategy.example4.version5;

/**
 * @Author: w
 * @Date: 2021/5/28 10:28
 */
public class SpeedSlowStrategy implements SpeedStrategy {

    @Override
    public Integer speed() {
        return 5;
    }
}
