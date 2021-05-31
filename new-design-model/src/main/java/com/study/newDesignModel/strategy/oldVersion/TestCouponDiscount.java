package com.study.newDesignModel.strategy.oldVersion;

/**
 * @Author: w
 * @Date: 2021/5/31 15:13
 */
public class TestCouponDiscount {

    public static void main(String[] args) {
        CouponDiscountService couponDiscountService = new CouponDiscountService();
        Double totalMoney = couponDiscountService.discountAmount(100.0, 2, 30.0, 5.0);
        System.out.println("结算价格为："+totalMoney);
    }
}
