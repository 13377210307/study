package com.design.strategy.example5;

import lombok.Data;

/**
 * @Author: w
 * @Date: 2021/5/30 14:46
 */
@Data
public abstract class Role {

    // 名称
    private String name;

    // 外观
    private String display;

    // 攻击
    private String attack;

    // 防御
    private String defence;

}
