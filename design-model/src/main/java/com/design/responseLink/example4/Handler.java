package com.design.responseLink.example4;

import lombok.Data;

/**
 * @Author: w
 * @Date: 2021/5/26 14:24
 */
@Data
public abstract class Handler {

    // 下一个节点处理
    private Handler next;

    // 处理费用审核
    public abstract void handExpense(Integer money);
}
