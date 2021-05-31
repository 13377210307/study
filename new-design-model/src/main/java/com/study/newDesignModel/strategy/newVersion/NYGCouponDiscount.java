package com.study.newDesignModel.strategy.newVersion;


/**
 * @Author: w
 * @Date: 2021/5/31 15:19
 * n元购
 */
public class NYGCouponDiscount implements CouponDiscount<Double> {

    @Override
    public Double discountAmount(Double discountPrice,Double price) {
        return discountPrice;
    }
}
