package com.jdk8.stream.example;

import cn.hutool.core.collection.CollectionUtil;
import com.jdk8.stream.entity.Dish;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: w
 * @Date: 2021/5/14 9:42
 * 案例一：
 * 筛选出卡路里小于400的菜肴
 * 对筛选出的菜肴进行一个排序
 * 获取排序后菜肴的名字
 */
public class Example1 {

    public static void main(String[] args) {
        List<Dish> dishes = new ArrayList<>();
        InitDish.initDish(dishes);

        // 旧方法
        /*List<String> names = oldMethod(dishes);
        if (CollectionUtil.isNotEmpty(names)) {
            for (String name : names) {
                System.out.println(name);
            }
        }*/

        // 新方法
        List<String> names = newMethod(dishes);
        if (CollectionUtil.isNotEmpty(names)) {
            names.forEach(System.out::println);
        }

    }

    // jdk8之前方法
    private static List<String> oldMethod(List<Dish> dishes) {
        List<Dish> lowCaloriesDish = new ArrayList<Dish>();
        // 获取小于400的菜
        if (CollectionUtil.isNotEmpty(dishes)) {
            for (Dish dish : dishes) {
                if (dish.getCalories() < 400) {
                    lowCaloriesDish.add(dish);
                }
            }
        }

        // 进行排序
        Collections.sort(lowCaloriesDish, new Comparator<Dish>() {
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(),o2.getCalories());
            }
        });

        List<String> names = new ArrayList<String>();
        // 获取名称
        for (Dish caloriesDish : lowCaloriesDish) {
            names.add(caloriesDish.getName());
        }
        return names;
    }

    // jdk8之后方法
    private static List<String> newMethod(List<Dish> dishes) {
        return dishes.stream()
                .filter(dish -> dish.getCalories() < 400) // 过滤
                .sorted(Comparator.comparing(Dish::getCalories))  // 排序
                .map(Dish::getName) // 获取名称
                .collect(Collectors.toList()); // 转成List
    }

}
