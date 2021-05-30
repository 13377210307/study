package com.design.strategy.example5;

/**
 * @Author: w
 * @Date: 2021/5/30 15:02
 */
public class TestStrategy {

    public static void main(String[] args) {

        Magi magi = new Magi();
        magi.setName("法师");
        magi.setDisplay("戴帽子");
        magi.setAttack(new AttackStrongStrategy().attack());
        magi.setDefence(new DefenceWeakStrategy().defence());

        System.out.println("角色名称：" + magi.getName() + " 角色形象：" + magi.getDisplay() + " 角色攻击力："+magi.getAttack()+ " 角色防御力："+magi.getDefence());

        Warrior warrior = new Warrior();
        warrior.setName("战士");
        warrior.setDisplay("持刀");
        warrior.setAttack(new AttackNormalStrategy().attack());
        warrior.setDefence(new DefenceNormalStrategy().defence());
        System.out.println("角色名称：" + warrior.getName() + " 角色形象：" + warrior.getDisplay() + " 角色攻击力："+warrior.getAttack()+ " 角色防御力："+warrior.getDefence());
    }
}
