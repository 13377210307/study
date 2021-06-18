package com.middleWare.rabbitMq.reliable.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: w
 * @Date: 2021/6/18 15:22
 */
@Data
public class ConfirmOrder implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;
}
