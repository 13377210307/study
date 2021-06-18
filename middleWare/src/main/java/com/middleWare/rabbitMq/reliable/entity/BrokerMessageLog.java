package com.middleWare.rabbitMq.reliable.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @Author: w
 * @Date: 2021/6/18 15:23
 */
@Data
public class BrokerMessageLog {

    @TableId(type = IdType.AUTO)
    private Long messageId;

    private String message;

    private Integer tryCount;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private Long orderId;
}
