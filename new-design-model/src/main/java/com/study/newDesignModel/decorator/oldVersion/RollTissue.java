package com.study.newDesignModel.decorator.oldVersion;

/**
 * @Author: w
 * @Date: 2021/6/2 9:02
 * 卷纸
 */
public class RollTissue implements Tissue {

    @Override
    public String createTissue() {
        return "卷纸";
    }
}
