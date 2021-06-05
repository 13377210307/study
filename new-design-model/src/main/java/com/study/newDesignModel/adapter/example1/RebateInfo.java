package com.study.newDesignModel.adapter.example1;

import lombok.Data;

import java.util.Date;

/**
 * @Author: w
 * @Date: 2021/6/4 8:58
 * 同一消息体
 */
@Data
public class RebateInfo {

    // 用户id
    private String userId;

    // 业务id
    private String bizId;

    // 业务时间
    private Date bizDate;

    // 业务描述
    private String desc;
}
