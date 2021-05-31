package com.study.newDesignModel.strategy.newVersion;

import java.util.Map;

/**
 * @Author: w
 * @Date: 2021/5/31 15:17
 * 满减折扣
 * 1. 判断满足x元后-n元，否则不减
 * 2. 最低支付金额1元
 */
public class MJCouponDiscount implements CouponDiscount<Map<String,Object>> {

    @Override
    public Double discountAmount(Map<String,Object> couponInfo,Double price) {
        Double x = Double.parseDouble(couponInfo.get("x").toString());
        Double o = Double.parseDouble(couponInfo.get("n").toString());
        return price >= x ? price - o : price;
    }
}
