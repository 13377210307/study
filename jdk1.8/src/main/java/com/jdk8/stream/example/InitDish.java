package com.jdk8.stream.example;

import com.jdk8.stream.entity.Dish;
import com.jdk8.stream.entity.Type;

import java.util.List;

/**
 * @Author: w
 * @Date: 2021/5/14 10:19
 * 初始化菜肴
 */
public class InitDish {

    // 初始化菜肴
    public static void initDish(List<Dish> dishes) {
        Dish dish1 = new Dish();
        dish1.setName("鱼香肉丝");
        dish1.setVegetarian(false);
        dish1.setCalories(500);
        Type type1 = new Type();
        type1.setType(1);
        type1.setName("类型1");
        dish1.setType(type1);
        dishes.add(dish1);

        Dish dish2 = new Dish();
        dish2.setName("隆江猪脚饭");
        dish2.setVegetarian(false);
        dish2.setCalories(700);
        dish2.setType(type1);
        dishes.add(dish2);

        Dish dish3 = new Dish();
        dish3.setName("凉拌黄瓜");
        dish3.setVegetarian(true);
        dish3.setCalories(200);
        dish3.setType(type1);
        dishes.add(dish3);

        Dish dish4 = new Dish();
        dish4.setName("水煮白菜");
        dish4.setVegetarian(true);
        dish4.setCalories(250);
        Type type2 = new Type();
        type2.setType(2);
        type2.setName("类型2");
        dish4.setType(type2);
        dishes.add(dish4);

        Dish dish5 = new Dish();
        dish5.setName("水煮番茄");
        dish5.setVegetarian(true);
        dish5.setCalories(300);
        dish5.setType(type2);
        dishes.add(dish5);
    }
}
