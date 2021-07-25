package com.design.observe.ticketNotify;

import lombok.Data;

import java.util.Map;

/**
 * @Author: w
 * @Date: 2021/7/23 9:49
 * 携程售票处
 */
@Data
public class XieChengSaleTicketOffice extends SaleTicketOffice {


    @Override
    public void updateData(Map<String, Object> map) {
        String publishName = (String)map.get("name");
        String msg = (String)map.get("msg");
        System.out.println("【"+publishName+"】："+"亲爱的【"+name+"】，"+msg);
    }
}
