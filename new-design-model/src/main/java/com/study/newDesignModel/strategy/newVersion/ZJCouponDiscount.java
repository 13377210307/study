package com.study.newDesignModel.strategy.newVersion;

/**
 * @Author: w
 * @Date: 2021/5/31 15:18
 * 直减折扣
 */
public class ZJCouponDiscount implements CouponDiscount<Double> {

    @Override
    public Double discountAmount(Double discountPrice,Double price) {
        return price > discountPrice ? price - discountPrice : price;
    }
}
