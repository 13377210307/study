package com.design.bridge.example3;

import lombok.Data;

/**
 * @Author: w
 * @Date: 2021/6/2 22:44
 */
@Data
public abstract class Phone {

    private Brand brand;

    abstract void call();
}
