package com.design.observe.ticketNotify;

/**
 * @Author: w
 * @Date: 2021/7/23 9:54
 */
public class TestTicket {

    public static void main(String[] args) {
        // 创建发票处
        PublishTicketOffice chinaTicketOffice = new ChinaPublishTicketOffice();
        chinaTicketOffice.setName("中国铁路");

        // 创建售票处
        SaleTicketOffice xieChengSaleTicketOffice = new XieChengSaleTicketOffice();
        xieChengSaleTicketOffice.setName("携程旅行");
        SaleTicketOffice feiZhuSaleTicketOffice = new FeiZhuSaleTicketOffice();
        feiZhuSaleTicketOffice.setName("飞猪旅行");

        // 加入售票处
        chinaTicketOffice.addObservers(xieChengSaleTicketOffice);
        chinaTicketOffice.addObservers(feiZhuSaleTicketOffice);

        // 通知
        chinaTicketOffice.notifyAllObservers();

        // 移除售票处
        chinaTicketOffice.removeObservers(feiZhuSaleTicketOffice);

        // 通知
        chinaTicketOffice.notifyAllObservers();

    }
}
