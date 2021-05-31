package com.study.newDesignModel.strategy.newVersion;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: w
 * @Date: 2021/5/31 15:30
 */
public class TestCouponDiscount {

    public static void main(String[] args) {
        CouponDiscount<Map<String,Object>> mJCouponDiscount = new MJCouponDiscount();
        Map<String,Object> map = new HashMap<>();
        map.put("x",100);
        map.put("n",30);
        Double totalPrice = mJCouponDiscount.discountAmount(map, 200.0);
        System.out.println("结算价格为："+totalPrice);
    }
}
