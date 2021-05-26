package com.design.responseLink.example4;

/**
 * @Author: w
 * @Date: 2021/5/26 14:35
 */
public class BossHandler extends Handler {

    @Override
    public void handExpense(Integer money) {
        if (money > 2000) {
            if (getNext() != null) {
                getNext().handExpense(money);
            }else {
                System.out.println("你申请的经费过多，现无人审批");
            }
        }else {
            System.out.println("你申请的经费经过老板审批成功");
        }
    }
}
