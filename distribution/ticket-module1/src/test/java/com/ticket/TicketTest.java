package com.ticket;

import com.ticket.config.RedissonConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.Redisson;
import org.redisson.api.RKeys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: w
 * @Date: 2021/7/19 9:22
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TicketTest {

    @Autowired
    private Redisson redisson;

    @Test
    public void testGetTicketStock() {
        RKeys keys = this.redisson.getKeys();
        System.out.println(keys);
    }
}
