package com.study.newDesignModel.decorator.newVersion;

import lombok.Data;

/**
 * @Author: w
 * @Date: 2021/6/2 9:35
 * 颜色属性
 */
@Data
public abstract class Color implements Tissue{

    private Tissue tissue;
}
