package com.jdk8.stream.example;

import cn.hutool.core.collection.CollectionUtil;
import com.jdk8.stream.entity.Dish;
import com.jdk8.stream.entity.Type;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: w
 * @Date: 2021/5/14 10:16
 * 将同一类型的菜肴放到一个Map中
 */
public class Example2 {

    public static void main(String[] args) {
        // 初始化菜肴
        List<Dish> dishes = new ArrayList<>();
        InitDish.initDish(dishes);

        // 旧方法
        /*Map<String, List<Dish>> map = oldMethod(dishes);
        if (CollectionUtil.isNotEmpty(map)) {
            for (String key : map.keySet()) {
                if (CollectionUtil.isNotEmpty(map.get(key))) {
                    for (Dish dish : map.get(key)) {
                        System.out.println(dish.getName()+"："+dish.getType().getName());
                    }
                }
            }
        }*/

        /*Map<Type, List<Dish>> typeListMap = newMethod(dishes);
        if (CollectionUtil.isNotEmpty(typeListMap)) {
            for (Type key : typeListMap.keySet()) {
                if (CollectionUtil.isNotEmpty(typeListMap.get(key))) {
                    for (Dish dish : typeListMap.get(key)) {
                        System.out.println(dish.getName() + "：" + dish.getType().getName());
                    }
                }
            }
        }*/
    }

    // 旧方法
    private static Map<String, List<Dish>> oldMethod(List<Dish> dishes) {
        Map<String,List<Dish>> map = new HashMap<>();
        /*// 先将同一类型的菜肴放到一块
        if (CollectionUtil.isNotEmpty(dishes)) {
            for (Dish dish : dishes) {
                if (CollectionUtil.isNotEmpty(map)) {
                    for (String key : map.keySet()) {
                        List<Dish> dishes1 = map.get(key);
                        dishes1.add(dish);
                        map.put(key,dishes1);
                    }
                }else {
                    List<Dish> dishes1 = new ArrayList<>();
                    dishes1.add(dish);
                    map.put(dish.getType().getName(),dishes1);
                }
            }
        }*/
        if (CollectionUtil.isNotEmpty(dishes)) {
            for (Dish dish : dishes) {
                String key = dish.getType().getName();
                // 不存在的进行初始化
                if (map.get(key) == null) {
                    List<Dish> newDishes = new ArrayList<>();
                    newDishes.add(dish);
                    map.put(key,newDishes);
                }else {
                    // 存在，直接追加
                    map.get(key).add(dish);
                }
            }
        }
        return map;
    }

    // 新方法
    private static Map<Type, List<Dish>> newMethod(List<Dish> dishes) {
        Map<Type,List<Dish>> map = new HashMap<>();
        // 通过分组函数实现
        if (CollectionUtil.isNotEmpty(dishes)) {
            map = dishes.stream().collect(Collectors.groupingBy(Dish::getType));
        }
        return map;
    }


}

