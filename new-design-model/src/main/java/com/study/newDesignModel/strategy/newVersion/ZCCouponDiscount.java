package com.study.newDesignModel.strategy.newVersion;

/**
 * @Author: w
 * @Date: 2021/5/31 15:19
 * 折扣券
 */
public class ZCCouponDiscount implements CouponDiscount<Double> {

    @Override
    public Double discountAmount(Double discountPrice,Double price) {
        return price * discountPrice;
    }
}
