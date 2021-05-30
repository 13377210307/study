package com.design.state.example1;

/**
 * @Author: w
 * @Date: 2021/5/29 11:59
 */
public class TestRaffle {

    public static void main(String[] args) {
        // 创建活动对象，设置奖品个数
        RaffleActivity raffleActivity = new RaffleActivity(10);

        // 连续抽奖300次
        for (int i = 0; i < 300; i++) {
            System.out.println("------------第"+(i+1)+"次抽奖---------------------");
            // 扣积分
            raffleActivity.deductMoney();
            // 抽奖
            raffleActivity.raffle();
        }
    }
}
