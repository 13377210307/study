package com.design.responseLink.example2;

/**
 * @Author: w
 * @Date: 2021/5/24 8:52
 */
public class DebugLogger extends Logger {

    public DebugLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("开始输出：" + message);
    }
}
