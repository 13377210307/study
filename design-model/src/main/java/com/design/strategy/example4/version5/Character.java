package com.design.strategy.example4.version5;

import lombok.Data;

/**
 * @Author: w
 * @Date: 2021/5/28 10:13
 */
@Data
public abstract class Character {

    // 移动策略
    private MoveStrategy moveStrategy;

    // 攻击策略
    private AttackStrategy attackStrategy;

    // 速度策略
    private SpeedStrategy speedStrategy;

    abstract String display();
}
