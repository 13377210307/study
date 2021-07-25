package com.basic.classAndObject.abstractStudy.apply;

/**
 * @Author: w
 * @Date: 2021/7/24 10:52
 * 模板方法
 */
public abstract class Template {

    // 任务
    public abstract void task();

    // 计算完成某个任务需要的时间
    public void calculateTaskTime() {
        long start = System.currentTimeMillis();
        task();
        long end = System.currentTimeMillis();
        System.out.println("该任务总共花费" + (end-start) + "时间");
    }
}
