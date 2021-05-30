package com.design.state.example1;

/**
 * @Author: w
 * @Date: 2021/5/29 11:37
 * 发放奖品状态
 */
public class DispenseState extends State {

    private RaffleActivity activity;

    public DispenseState(RaffleActivity activity) {
        this.activity = activity;
    }

    @Override
    public void deductMoney() {
        System.out.println("当前状态不能扣除积分");
    }

    @Override
    public Boolean raffle() {
        System.out.println("当前状态不能抽奖");
        return false;
    }

    @Override
    public void dispensePrize() {
        if (activity.getCount() > 0) {
            System.out.println("恭喜您中奖了");
            // 设置状态为不能抽奖
            activity.setState(activity.getNoRaffleState());
        }else {
            // 抽中奖品但是发放完了
            System.out.println("很遗憾，奖品发放完了");
            // 设置状态为奖品发放完毕
            activity.setState(activity.getDispenseOutState());
        }
    }
}
