package com.design.state.example2.version1;

import lombok.Data;

/**
 * @Author: w
 * @Date: 2021/5/29 17:20
 */
@Data
public class OrderChange {

    // 工单号
    private String orderNum;

    // 0：已创建  1：主任分配   2：检验员检验  3：报告审核人审核  4：归档打印   未生成报告得工单需要计入统计（0，1，2）
    private Integer status;

    // 工单是否完成  流转到4得时候就是完成
    private Boolean orderFinished = false;

    public OrderChange(String orderNum, Integer status, Boolean orderFinished) {
        this.orderNum = orderNum;
        this.status = status;
        this.orderFinished = orderFinished;
    }

    public void work() {
        if (status == 0) {
            System.out.println(orderNum + " 订单状态是已创建，订单下一个操作人是主任");
        }else if(status == 1) {
            System.out.println(orderNum + " 订单状态是主任分配，订单下一个操作人是检验员");
        }else if (status == 2) {
            System.out.println(orderNum + " 订单状态是检验员检验，订单下一个操作人是报告审核人");
        }else if (status == 3) {
            System.out.println(orderNum + " 订单状态是报告审核人审核，订单下一个操作人是打印员");
        }else if (status == 4) {
            System.out.println(orderNum + " 订单状态是归档打印，订单下一个操作人是无");
        }

        // 计入统计
        if(orderFinished) {
            System.out.println(orderNum + " 订单状态是已完成，订单已完成");
        }else {
            if (status == 3) {
                System.out.println(orderNum + " 不需要计入统计");
            }else if (status == 4) {
                System.out.println(orderNum + " 不需要计入统计");
            }else {
                System.out.println(orderNum + " 需要计入统计");
            }
        }
    }
}
