package com.design.compose.example1.version.vo;

import lombok.Data;

/**
 * @Author: w
 * @Date: 2021/5/31 22:44
 */
@Data
public class TreeNodeLink {

    private Long nodeIdFrom;        //节点From

    private Long nodeIdTo;          //节点To

    private Integer ruleLimitType;  //限定类型；1:=;2:>;3:<;4:>=;5<=;6:enum[枚举范围]

    private String ruleLimitValue;  //限定值
}
