package com.design.responseLink.example3;

/**
 * @Author: w
 * @Date: 2021/5/24 9:07
 * 班主任类
 */
public class ClassAdviser extends Leader {

    @Override
    public void handlerLeaveApproval(int leaveDay) {
        if (leaveDay > 2) {
            // 请假天数超过两天，由下一个节点领导进行审批
            if (getNext() != null) {
                getNext().handlerLeaveApproval(leaveDay);
            }else {
                System.out.println("请假天数过多，无人有权进行审批");
            }
        }else {
            System.out.println("班主任批准本次请求申请");
        }
    }
}
