package com.design.responseLink.example4;

/**
 * @Author: w
 * @Date: 2021/5/26 14:23
 */
public class ManagerHandler extends Handler {

    @Override
    public void handExpense(Integer money) {
        if (money > 500) {
            if (getNext() != null) {
                getNext().handExpense(money);
            }else {
                System.out.println("你申请的经费过多，现无人审批");
            }
        }else {
            // 经理自身审批
            System.out.println("你申请的经费经过经理审批成功");
        }
    }
}
