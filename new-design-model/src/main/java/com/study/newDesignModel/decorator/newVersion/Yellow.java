package com.study.newDesignModel.decorator.newVersion;

/**
 * @Author: w
 * @Date: 2021/6/2 9:39
 */
public class Yellow extends Color{

    @Override
    public String createTissue() {
        return "黄色" + super.getTissue().createTissue();
    }
}
