package com.design.observe.ticketNotify;

import cn.hutool.core.collection.CollectionUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: w
 * @Date: 2021/7/23 9:12
 * 中国发行票
 */
@Data
public class ChinaPublishTicketOffice extends PublishTicketOffice {

    @Override
    public void addObservers(SaleTicketOffice saleTicketOffice) {
        // 判断加入观察者是否加入过了
        Boolean existObserver = isExistObserver(saleTicketOffice);
        if (existObserver) {
            System.out.println("【"+name+"】：【"+saleTicketOffice.name+"】售票处已经添加过了，请勿重复添加");
        }else {
            saleTicketOffices.add(saleTicketOffice);
        }
    }

    @Override
    public void removeObservers(SaleTicketOffice saleTicketOffice) {
        // 判断加入观察者是否加入过了
        Boolean existObserver = isExistObserver(saleTicketOffice);
        if (existObserver) {
            saleTicketOffices.remove(saleTicketOffice);
        }else {
            System.out.println("【"+name+"】：【"+saleTicketOffice.name+"】售票处未添加，移除失败");
        }
    }

    @Override
    public void notifyAllObservers() {
        if (CollectionUtil.isNotEmpty(saleTicketOffices)) {
            for (SaleTicketOffice saleTicketOffice : saleTicketOffices) {
                Map<String,Object> map = new HashMap<>();
                map.put("name",name);
                map.put("msg","今日开始发票");
                saleTicketOffice.updateData(map);
            }
        }
    }

    @Override
    public Boolean isExistObserver(SaleTicketOffice saleTicketOffice) {
        List<String> names = new ArrayList<>();
        String addName = saleTicketOffice.getName();
        if (CollectionUtil.isNotEmpty(saleTicketOffices)) {
            names = saleTicketOffices.stream().map(SaleTicketOffice :: getName).collect(Collectors.toList());
        }
        return names.contains(addName);
    }


}
