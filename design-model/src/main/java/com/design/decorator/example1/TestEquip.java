package com.design.decorator.example1;

/**
 * @Author: w
 * @Date: 2021/5/31 9:19
 */
public class TestEquip {

    public static void main(String[] args) {
        System.out.println("镶嵌了两颗红宝石和一个黄宝石的屠龙宝刀");
        EquipDecorate redGemDecorator = new RedGemDecorator(new RedGemDecorator(new YellowGemDecorator(new Weapon())));
        System.out.println("描述：" + redGemDecorator.description());
        System.out.println("攻击力：" + redGemDecorator.calculate());


    }
}
