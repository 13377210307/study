package com.thread.practice.communication.breed;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: w
 * @Date: 2021/7/23 17:48
 * 面包箱
 * 容量
 * 面包
 */
@Data
public class BreedBox {

    private Integer capacity;

    private LinkedList<Breed> breeds = new LinkedList<>();

}
