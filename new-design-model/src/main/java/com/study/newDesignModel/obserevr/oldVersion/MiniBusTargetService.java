package com.study.newDesignModel.obserevr.oldVersion;

/**
 * @Author: w
 * @Date: 2021/6/1 21:55
 */
public class MiniBusTargetService {

    // 模拟摇号
    public String lottery(String userId) {
        return Math.abs(userId.hashCode()) % 2 == 0 ? "恭喜你，编码".concat(userId).concat("在本次摇号中中签") :
                "很遗憾，编码".concat(userId).concat("在本次摇号未中签或摇号资格已过期");
    }
}
