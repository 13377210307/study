package com.design.observe.ticketNotify;

import lombok.Data;

import java.util.Map;

/**
 * @Author: w
 * @Date: 2021/7/23 9:03
 * 售票处抽象类：售票可能不止一家，比如携程、飞猪、12306等
 *
 * 属性
 * 1：名称
 *
 * 方法
 * 更新数据（更新票数）
 */
@Data
public abstract class SaleTicketOffice {

    // 名称
    public String name;

    // 更新数据
    public abstract void updateData(Map<String,Object> map);
}
