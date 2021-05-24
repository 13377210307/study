package com.design.responseLink.example2;

/**
 * @Author: w
 * @Date: 2021/5/24 8:47
 */
public class InfoLogger extends Logger {

    public InfoLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("开始输出：" + message);
    }
}
