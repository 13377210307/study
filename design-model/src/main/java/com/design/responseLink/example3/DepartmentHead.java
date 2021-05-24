package com.design.responseLink.example3;

/**
 * @Author: w
 * @Date: 2021/5/24 9:14
 * 系主任类
 */
public class DepartmentHead extends Leader {

    @Override
    public void handlerLeaveApproval(int leaveDay) {
        if (leaveDay > 7) {
            if (getNext() != null) {
                getNext().handlerLeaveApproval(leaveDay);
            }else {
                System.out.println("请假天数过多，无人有权进行审批");
            }
        }else{
            System.out.println("系主任批准本次请假申请");
        }
    }
}
