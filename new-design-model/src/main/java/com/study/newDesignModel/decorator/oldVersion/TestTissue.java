package com.study.newDesignModel.decorator.oldVersion;

/**
 * @Author: w
 * @Date: 2021/6/2 9:10
 */
public class TestTissue {

    public static void main(String[] args) {
        Tissue fourRollTissue = new FourRollTissue();
        String tissue = fourRollTissue.createTissue();
        System.out.println("生产出的纸是："+tissue);
    }
}
