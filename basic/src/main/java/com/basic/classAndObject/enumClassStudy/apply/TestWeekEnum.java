package com.basic.classAndObject.enumClassStudy.apply;

/**
 * @Author: w
 * @Date: 2021/7/25 21:03
 */
public class TestWeekEnum {

    public static void main(String[] args) {
        String[] weekValues = new String[7];
        weekValues[0] = WeekEnum.MONDAY.getName();
        weekValues[1] = WeekEnum.TUESDAY.getName();
        weekValues[2] = WeekEnum.WEDNESDAY.getName();
        weekValues[3] = WeekEnum.THURSDAY.getName();
        weekValues[4] = WeekEnum.FRIDAY.getName();
        weekValues[5] = WeekEnum.SATURDAY.getName();
        weekValues[6] = WeekEnum.SUNDAY.getName();

        for (String weekValue : weekValues) {
            System.out.println(weekValue);
        }

    }
}
