package com.design.bridge.example1;

import com.design.bridge.example1.Color;

/**
 * @Author: w
 * @Date: 2021/5/27 8:57
 */
public class RedColor implements Color {

    @Override
    public String using() {
        return "红色";
    }
}
