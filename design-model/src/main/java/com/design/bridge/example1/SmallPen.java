package com.design.bridge.example1;

import com.design.bridge.example1.Color;
import com.design.bridge.example1.Pen;

/**
 * @Author: w
 * @Date: 2021/5/27 8:55
 */
public class SmallPen extends Pen {

    @Override
    void draw(Color color) {
        String name = color.using();
        System.out.println("型号为小号的画笔画出了"+name+"的线条");
    }
}
