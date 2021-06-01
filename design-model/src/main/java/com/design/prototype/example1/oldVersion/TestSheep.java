package com.design.prototype.example1.oldVersion;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: w
 * @Date: 2021/6/1 22:25
 */
public class TestSheep {

    public static void main(String[] args) {
        List<Sheep> sheeps = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            Sheep sheep = new Sheep();
            sheep.setName("Tom");
            sheep.setAge(1);
            sheep.setColor("白色");
            sheeps.add(sheep);
        }

        sheeps.forEach(System.out::println);
    }
}
