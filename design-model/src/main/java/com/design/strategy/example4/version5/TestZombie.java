package com.design.strategy.example4.version5;

/**
 * @Author: w
 * @Date: 2021/5/28 10:34
 */
public class TestZombie {

    public static void main(String[] args) {

        Character greenHeadZombie = new GreenHeadZombie();

        String display = "";
        String move = "";
        String attack = "";
        Integer speed = 0;

        // 初始化僵尸：刚开始的时候是没有移动、速度以及攻击的
        greenHeadZombie.setSpeedStrategy(new SpeedNoStrategy());
        greenHeadZombie.setAttackStrategy(new AttackNoStrategy());
        greenHeadZombie.setMoveStrategy(new MoveNoStrategy());

        display = greenHeadZombie.display();
        move = greenHeadZombie.getMoveStrategy().move();
        speed = greenHeadZombie.getSpeedStrategy().speed();
        attack = greenHeadZombie.getAttackStrategy().attack();

        System.out.println(display + "的移动方式是：" + move + " 移动速度为：" + speed + " 攻击方式是：" + attack);


        // 点击开始按钮：设置移动、速度、攻击
        greenHeadZombie.setSpeedStrategy(new SpeedNormalStrategy());
        greenHeadZombie.setAttackStrategy(new AttackNormalStrategy());
        greenHeadZombie.setMoveStrategy(new MoveNormalStrategy());

        move = greenHeadZombie.getMoveStrategy().move();
        speed = greenHeadZombie.getSpeedStrategy().speed();
        attack = greenHeadZombie.getAttackStrategy().attack();
        System.out.println(display + "的移动方式是：" + move + " 移动速度为：" + speed + " 攻击方式是：" + attack);

        // 碰到障碍物：速度减慢
        greenHeadZombie.setMoveStrategy(new MoveSlowStrategy());
        greenHeadZombie.setSpeedStrategy(new SpeedSlowStrategy());
        move = greenHeadZombie.getMoveStrategy().move();
        speed = greenHeadZombie.getSpeedStrategy().speed();
        System.out.println(display + "的移动方式是：" + move + " 移动速度为：" + speed + " 攻击方式是：" + attack);

    }
}
