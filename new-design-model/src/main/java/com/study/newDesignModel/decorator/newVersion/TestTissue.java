package com.study.newDesignModel.decorator.newVersion;

/**
 * @Author: w
 * @Date: 2021/6/2 9:30
 */
public class TestTissue {


    public static void main(String[] args) {
        FourLandDecorator fourLandDecorator = new FourLandDecorator();
        fourLandDecorator.setTissue(new RollTissue());
        Yellow yellow = new Yellow();
        yellow.setTissue(fourLandDecorator);
        String tissue = yellow.createTissue();
        System.out.println(tissue);
    }
}
