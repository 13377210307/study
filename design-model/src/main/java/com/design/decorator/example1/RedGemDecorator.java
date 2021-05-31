package com.design.decorator.example1;

import lombok.Data;

/**
 * @Author: w
 * @Date: 2021/5/31 9:16
 */
@Data
public class RedGemDecorator implements EquipDecorate {

    // 在宝石中维护装备
    private Equip equip;

    // 一颗宝石只能镶嵌在一个装备身上
    public RedGemDecorator(Equip equip) {
        this.equip = equip;
    }

    @Override
    public String description() {
        return equip.description() + " + 红宝石";
    }

    @Override
    public Integer calculate() {
        return 15 + equip.calculate();
    }
}
