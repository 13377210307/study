package com.design.strategy.example4.version4;


/**
 * @Author: w
 * @Date: 2021/5/28 9:00
 */
public class TestCharacter {

    public static void main(String[] args) {
        Character noAttackZombie = new NoAttackZombie();
        String attack = noAttackZombie.attack();
        String display = noAttackZombie.display();
        String move = noAttackZombie.move();
        Integer speed = noAttackZombie.speed();

        System.out.println(display + "的攻击方式是：" +attack+ " 移动方式是：" + move +" 移动速度为：" + speed);
    }
}
