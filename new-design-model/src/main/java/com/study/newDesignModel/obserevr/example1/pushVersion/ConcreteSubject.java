package com.study.newDesignModel.obserevr.example1.pushVersion;

/**
 * @Author: w
 * @Date: 2021/6/2 17:48
 */
public class ConcreteSubject extends Subject {

    // 消息
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
        // 调用父类通知方法
        super.notifyAllObservers(msg);
    }
}
