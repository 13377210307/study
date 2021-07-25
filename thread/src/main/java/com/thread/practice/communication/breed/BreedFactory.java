package com.thread.practice.communication.breed;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author: w
 * @Date: 2021/7/23 17:44
 * 面包工厂：里面有三个工人做面包；面包数等于面包箱钟数量的时候就停止做面包
 */
public class BreedFactory {


    // 生产面包
    public void createBreed(BreedBox breedBox,String id) {

        while (true) {
            synchronized (breedBox) {
                if (breedBox.getCapacity() == breedBox.getBreeds().size()) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("面包箱快放不下去了，先把面包卖了吧");
                    // 停止生产
                    try {
                        breedBox.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    // 生产面包并唤醒商店进行售卖
                    Breed breed = new Breed();
                    breed.setId(id);
                    breed.setName("面包"+id+"号");
                    breedBox.getBreeds().addLast(breed);
                    System.out.println("【" +Thread.currentThread().getName() + "】生产面包：" + breed.getName());
                    breedBox.notifyAll();
                }
            }
        }
    }
}
