package com.design.observe.ticketNotify;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: w
 * @Date: 2021/7/23 8:59
 * 发票处抽象类
 *
 * 属性：
 * 1：名称
 * 2：观察者集合
 *
 * 方法：方法抽象出来，先不用在父类中进行具体实现，可能子类需要有不同得实现方式
 * 1：新增观察者
 * 2：移除观察者
 * 3：通知所有观察者
 */
@Data
public abstract class PublishTicketOffice {

    // 名称
    public String name;

    // 观察者
    public List<SaleTicketOffice> saleTicketOffices = new ArrayList<>();

    // 新增观察者
    public abstract void addObservers(SaleTicketOffice saleTicketOffice);

    // 移除观察者
    public abstract void removeObservers(SaleTicketOffice saleTicketOffice);

    // 通知所有观察者
    public abstract void notifyAllObservers();

    // 判断该售票处是否存在
    public abstract Boolean isExistObserver(SaleTicketOffice saleTicketOffice);


}
