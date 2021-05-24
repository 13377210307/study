package com.design.responseLink.example3;

/**
 * @Author: w
 * @Date: 2021/5/24 9:17
 * 院长类
 */
public class Dean extends Leader {

    @Override
    public void handlerLeaveApproval(int leaveDay) {
        if (leaveDay > 10) {
            if (getNext() != null) {
                getNext().handlerLeaveApproval(leaveDay);
            }else {
                System.out.println("请假天数过多，无人有权进行审批");
            }
        }else{
            System.out.println("院主任批准本次请假申请");
        }
    }
}
