package com.design.prototype.example1.newVersion;

/**
 * @Author: w
 * @Date: 2021/6/1 22:36
 */
public class Client {

    public static void main(String[] args) {
        Sheep sheep = new Sheep();
        sheep.setName("Tom");
        sheep.setAge(1);
        sheep.setColor("白色");
        Sheep sheep1 = (Sheep)sheep.clone();
        System.out.println(sheep.getName());
        System.out.println(sheep1.getName());
    }
}
