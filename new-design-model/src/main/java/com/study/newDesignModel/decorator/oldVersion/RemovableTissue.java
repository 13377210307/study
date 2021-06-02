package com.study.newDesignModel.decorator.oldVersion;

/**
 * @Author: w
 * @Date: 2021/6/2 9:04
 * 抽纸
 */
public class RemovableTissue implements Tissue {

    @Override
    public String createTissue() {
        return "抽纸";
    }
}
