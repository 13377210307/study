package com.thread.utils;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.NetUtil;

import javax.annotation.PostConstruct;

/**
 * @Author: w
 * @Date: 2021/6/21 22:14
 * 雪花算法
 */
public class IdGenerateUtil {

    private static long workerId = 0;
    private static long datacenterId = 1;
    private static Snowflake snowFlake = IdUtil.createSnowflake(workerId, datacenterId);

    @PostConstruct
    public static void init() {
        try {
            // 将网络ip转换成long
            workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取雪花ID
     * @return
     */
    public static synchronized long snowflakeId() {
        return snowFlake.nextId();
    }

    public static synchronized long snowflakeId(long workerId, long datacenterId) {
        Snowflake snowflake = IdUtil.createSnowflake(workerId, datacenterId);
        return snowflake.nextId();
    }

}
