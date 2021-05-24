package com.design.responseLink.example3;

import lombok.Data;

/**
 * @Author: w
 * @Date: 2021/5/24 9:04
 * 抽象领导类
 */
@Data
public abstract class Leader {

    // 下一个审批节点的领导
    private Leader next;

    // 处理请假申请
    public abstract void handlerLeaveApproval(int leaveDay);

}
