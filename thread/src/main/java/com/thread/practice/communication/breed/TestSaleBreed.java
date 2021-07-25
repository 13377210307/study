package com.thread.practice.communication.breed;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author: w
 * @Date: 2021/7/23 17:49
 */
public class TestSaleBreed {

    public static void main(String[] args) {
        BreedBox breedBox = new BreedBox();
        breedBox.setCapacity(20);

        // 创建面包工厂
        BreedFactory breedFactory = new BreedFactory();
        // 三个工人生产面包
        for (int i = 0; i < 3; i++) {
            int count = i + 1;
            String breedId = UUID.randomUUID().toString().replaceAll("-","");
            new Thread(() -> {
                breedFactory.createBreed(breedBox,breedId);
            },"工人" + count + "号").start();
        }

        // 创建面包商店
        BreedStore breedStore = new BreedStore();
        // 两个消费者买面包
        for (int i = 0; i < 2; i++) {
            int count = i + 1;
            new Thread(() -> {
                breedStore.saleBreed(breedBox);
            },"消费者" + count + "号").start();
        }
    }
}
