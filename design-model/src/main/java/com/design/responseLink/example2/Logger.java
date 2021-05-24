package com.design.responseLink.example2;

import lombok.Data;

/**
 * @Author: w
 * @Date: 2021/5/24 8:40
 * 抽象记录器
 */
@Data
public abstract class Logger {

    public static int INFO = 1;

    public static int DEBUG = 2;

    public static int ERROR = 3;

    protected int level;

    // 下一个责任链
    protected Logger next;

    public void logMessage(int level,String message) {

        if(this.level <= level){
            write(message);
        }

        // 判断是否包含下一个责任链
        if(next !=null){
            next.logMessage(level, message);
        }
    }

    abstract protected void write(String message);
}
