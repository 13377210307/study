package com.design.strategy.example4.version2;


/**
 * @Author: w
 * @Date: 2021/5/28 9:00
 */
public class TestCharacter {

    public static void main(String[] args) {
        Character greenHeadZombie = new GreenHeadZombie();
        String attack = greenHeadZombie.attack();
        String display = greenHeadZombie.display();
        String move = greenHeadZombie.move();
        Integer speed = greenHeadZombie.speed();

        System.out.println(display + "的攻击方式是：" +attack+ "移动方式是：" + move +"移动速度为：" + speed);
    }
}
