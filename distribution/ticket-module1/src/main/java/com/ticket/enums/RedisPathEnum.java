package com.ticket.enums;

/**
 * @Author: w
 * @Date: 2021/7/18 10:01
 */
public enum RedisPathEnum {

    TICKET_STOCK("distribution:ticketStock","票库存"),
    TICKET_LOCK("distribution:ticketLock","票分布式锁");

    public String path;

    public String desc;

    RedisPathEnum(String path, String desc) {
        this.path = path;
        this.desc = desc;
    }
}
