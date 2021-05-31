package com.study.newDesignModel.strategy.newVersion;

/**
 * @Author: w
 * @Date: 2021/5/31 15:16
 */
public interface CouponDiscount<T> {

    Double discountAmount(T couponInfo, Double price);

}
