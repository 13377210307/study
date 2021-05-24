package com.design.responseLink.example3;

/**
 * @Author: w
 * @Date: 2021/5/24 9:03
 *
 * 假如规定学生请假小于或等于 2 天，班主任可以批准；
 * 小于或等于 7 天，系主任可以批准；
 * 小于或等于 10 天，院长可以批准；
 * 其他情况不予批准。
 */
public class LeaveApproval {

    public static void main(String[] args) {
        // 组装责任链
        Leader classAdviser = new ClassAdviser();
        Leader departmentHead = new DepartmentHead();
        Leader dean = new Dean();
        classAdviser.setNext(departmentHead);
        departmentHead.setNext(dean);

        // 申请请假
        classAdviser.handlerLeaveApproval(8);

    }
}
