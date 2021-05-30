package com.design.state.example1;

/**
 * @Author: w
 * @Date: 2021/5/29 11:42
 * 奖品发放完毕状态
 */
public class DispenseOutState extends State{

    private RaffleActivity activity;

    public DispenseOutState(RaffleActivity activity) {
        this.activity = activity;
    }

    @Override
    public void deductMoney() {
        System.out.println("奖品发放完毕了，请下次参加");
    }

    @Override
    public Boolean raffle() {
        System.out.println("奖品发放完毕了，请下次参加");
        return false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("奖品发放完毕了，请下次参加");
    }
}
