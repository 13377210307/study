package com.design.state.example2.version1;

/**
 * @Author: w
 * @Date: 2021/5/29 17:35
 */
public class TestOrderChange {

    public static void main(String[] args) {
        OrderChange orderChange1 = new OrderChange("20210529",0,false);
        OrderChange orderChange2 = new OrderChange("20210528",1,false);
        OrderChange orderChange3 = new OrderChange("20210527",2,false);
        OrderChange orderChange4 = new OrderChange("20210526",3,false);
        OrderChange orderChange5 = new OrderChange("20210525",4,false);

        orderChange1.work();
        orderChange2.work();
        orderChange3.work();
        orderChange4.work();
        orderChange5.work();
    }
}
