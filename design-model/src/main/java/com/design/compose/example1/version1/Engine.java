package com.design.compose.example1.version1;

/**
 * @Author: w
 * @Date: 2021/5/31 22:00
 */
public class Engine {

    public String process(Integer sex, Integer age) {
        // 先按照性别分
        if (1 == sex) {
            // 分年龄
            if (age < 25) {
                return "switch游戏机100元优惠券";
            }
            if (age >= 25) {
                return "兰博基尼5元优惠券";
            }
        }
        if (2 == sex) {
            if (age < 25) {
                return "口红50元优惠券";
            }
            if (age >= 25) {
                return "某著名包包200元优惠券";
            }
        }
        return null;
    }
}
