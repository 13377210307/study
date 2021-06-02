package com.study.newDesignModel.obserevr.example1.pushVersion;

/**
 * @Author: w
 * @Date: 2021/6/2 17:42
 * 观察者
 */
public interface Observer {

    // 更新数据方法
    void updateData(String subjectName,String msg);

}
