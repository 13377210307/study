package com.design.state.example1;

/**
 * @Author: w
 * @Date: 2021/5/29 11:24
 *
 * 状态抽象类
 */
public abstract class State {

    // 扣除积分50
    public abstract void deductMoney();

    // 是否抽中奖品
    public abstract Boolean raffle();

    // 发放奖品
    public abstract void dispensePrize();
}
