package com.design.state.example1;

import java.util.Random;

/**
 * @Author: w
 * @Date: 2021/5/29 11:32
 * 可以抽奖状态
 */
public class CanRaffleState extends State {

    private RaffleActivity activity;

    public CanRaffleState(RaffleActivity activity) {
        this.activity = activity;
    }

    @Override
    public void deductMoney() {
        System.out.println("您已经扣除过积分了");
    }

    @Override
    public Boolean raffle() {
        System.out.println("正在抽奖，请稍候");
        Random random = new Random();
        int num = random.nextInt(10);
        // 10%中奖率
        if (num == 0) {
            // 改变活动状态为发放奖品
            activity.setState(activity.getDispenseState());
            return true;
        }else {
            System.out.println("谢谢惠顾");
            // 改变状态为不能抽奖
            activity.setState(activity.getNoRaffleState());
            return false;
        }
    }

    @Override
    public void dispensePrize() {
        System.out.println("您还未进行抽奖，不能发放奖品");
    }
}
