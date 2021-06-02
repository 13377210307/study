package com.study.newDesignModel.decorator.newVersion;

/**
 * @Author: w
 * @Date: 2021/6/2 9:26
 */
public class ThreeLandDecorator extends LandDecorator {


    @Override
    public String createTissue() {
        return "三层纸" + super.getTissue().createTissue();
    }
}
