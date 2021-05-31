package com.design.compose.example1.version1;

/**
 * @Author: w
 * @Date: 2021/5/31 22:07
 */
public class TestEngine {

    public static void main(String[] args) {
        Engine engine = new Engine();
        String process = engine.process(2, 40);
        System.out.println("您获取到了一张"+process+"请尽快使用");
    }
}
