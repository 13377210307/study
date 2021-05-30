package com.design.observe.example4;

import lombok.Data;

/**
 * @Author: w
 * @Date: 2021/5/30 11:22
 */
@Data
public abstract class Observer {

    public String name;

    // 获取主题消息
    abstract void updateData(String subjectName,Object msg);
}
