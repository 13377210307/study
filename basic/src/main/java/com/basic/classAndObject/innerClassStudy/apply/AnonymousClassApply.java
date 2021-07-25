package com.basic.classAndObject.innerClassStudy.apply;

/**
 * @Author: w
 * @Date: 2021/7/25 10:16
 * 匿名内部类使用
 */
public class AnonymousClassApply {

    public static void main(String[] args) {
        CellPhone cellPhone = new CellPhone();
        cellPhone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("加油啊，打工人...");
            }
        });
    }

}

interface Bell {
    void ring();
}

class CellPhone {
    public void alarmClock(Bell bell) {
        bell.ring();
    }
}
