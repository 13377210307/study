package com.design.state.example1;

/**
 * @Author: w
 * @Date: 2021/5/29 11:26
 * 不嫩抽奖状态
 */
public class NoRaffleState extends State {

    private RaffleActivity activity;

    public NoRaffleState(RaffleActivity activity) {
        this.activity = activity;
    }

    // 当前状态可以扣积分，扣除后将状态设置为可以抽奖状态
    @Override
    public void deductMoney() {
        System.out.println("扣除50积分成功，您可以抽奖了");
        activity.setState(activity.getCanRaffleState());
    }

    // 当前状态不能抽奖
    @Override
    public Boolean raffle() {
        System.out.println("您可用积分已不足50，不能进行抽奖");
        return false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("您还未进行抽奖，无法发放奖品");
    }
}
