package com.study.newDesignModel.obserevr.oldVersion;

/**
 * @Author: w
 * @Date: 2021/6/1 22:00
 */
public class LotteryServiceImpl implements LotteryService {

    private MiniBusTargetService miniBusTargetService = new MiniBusTargetService();

    @Override
    public String doDraw(String userId) {
        // 摇号
        String lottery = miniBusTargetService.lottery(userId);
        // 发短信通知
        System.out.println("发短信通知....");
        // 发邮件通知
        System.out.println("发邮件通知....");
        return lottery;
    }
}
