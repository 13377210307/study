package com.design.observe.example4;

import lombok.Data;

/**
 * @Author: w
 * @Date: 2021/5/30 11:38
 */
public class ObServer2 extends Observer {

    @Override
    public void updateData(String subjectName,Object msg) {
        System.out.println(name + "您关注的" + subjectName + "更新一条消息："+msg);
    }
}
