package com.thread.practice.communication.breed;

import java.util.concurrent.TimeUnit;

/**
 * @Author: w
 * @Date: 2021/7/23 17:44
 * 面包商店：售卖面包，当面包箱中的面包数量等于0时就停止售卖并唤醒面包工厂开始生产面包
 */
public class BreedStore {

    public void saleBreed(BreedBox breedBox) {
        while (true) {
            synchronized (breedBox) {
                if (0 == breedBox.getBreeds().size()) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 停止售卖
                    try {
                        System.out.println("面包箱中的面包已经卖完了，先等面包生产吧...");
                        breedBox.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    // 进行售卖并唤醒面包工厂进行生产
                    Breed breed = breedBox.getBreeds().removeFirst();
                    System.out.println("【" +Thread.currentThread().getName() + "】卖出面包："+breed.getName());
                    breedBox.notifyAll();
                }
            }
        }
    }
}
