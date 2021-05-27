package com.design.bridge.example1;

/**
 * @Author: w
 * @Date: 2021/5/27 8:54
 *
 */
public class BigPen extends Pen {

    @Override
    void draw(Color color) {
        String name = color.using();
        System.out.println("型号为大号的画笔画出了"+name+"的线条");
    }
}
