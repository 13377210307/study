package com.study.newDesignModel.strategy.oldVersion;

/**
 * @Author: w
 * @Date: 2021/5/31 15:00
 */
public class CouponDiscountService {

    public Double discountAmount(Double price, Integer type, Double discountPrice, Double extPrice) {
        // 直减券
        if (1 == type) {
            return price - discountPrice;
        }
        if (2 == type) {
            // 满减券，满多少减多少
            if (price < extPrice) {
                return price;
            }else {
                return price - extPrice;
            }
        }
        if (3 == type) {
            // 折扣券
            return price * discountPrice;
        }
        if (4 == type) {
            // n元购
            return discountPrice;
        }
        return 0.0;
    }
}
