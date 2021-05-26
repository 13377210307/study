package com.design.responseLink.example4;

/**
 * @Author: w
 * @Date: 2021/5/26 14:33
 */
public class DivideHandler extends Handler {

    @Override
    public void handExpense(Integer money) {
        if (money > 1000) {
            if (getNext() != null) {
                getNext().handExpense(money);
            }else {
                System.out.println("你申请的经费过多，现无人审批");
            }
        }else {
            System.out.println("你申请的经费经过总监审批成功");
        }
    }
}
