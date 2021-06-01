package com.study.newDesignModel.obserevr.oldVersion;

/**
 * @Author: w
 * @Date: 2021/6/1 22:03
 */
public class TestLottery {

    public static void main(String[] args) {
        LotteryService lotteryService = new LotteryServiceImpl();
        String msg = lotteryService.doDraw("2765789109876");
        System.out.println(msg);
    }
}
