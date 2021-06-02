package com.study.newDesignModel.decorator.newVersion;

/**
 * @Author: w
 * @Date: 2021/6/2 9:28
 */
public class FourLandDecorator extends LandDecorator {

    @Override
    public String createTissue() {
        return "四层纸" + super.getTissue().createTissue();
    }
}
