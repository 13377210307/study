package com.study.newDesignModel.decorator.newVersion;

import lombok.Data;

/**
 * @Author: w
 * @Date: 2021/6/2 9:24
 * 厚度抽象类
 */
@Data
public abstract class LandDecorator implements Tissue{

    private Tissue tissue;

}
