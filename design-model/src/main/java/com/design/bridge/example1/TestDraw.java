package com.design.bridge.example1;

import com.design.bridge.example1.*;

/**
 * @Author: w
 * @Date: 2021/5/27 8:59
 */
public class TestDraw {

    public static void main(String[] args) {
        Color blueColor = new BlueColor();
        Pen bigPen = new BigPen();
        Pen smallPen = new SmallPen();
        bigPen.draw(blueColor);
        smallPen.draw(blueColor);
    }
}
