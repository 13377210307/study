package com.ticket.service.impl;

import com.ticket.service.TicketService;
import org.springframework.stereotype.Service;

/**
 * @Author: w
 * @Date: 2021/7/17 11:29
 */
@Service
public class TicketServiceImpl implements TicketService {


    @Override
    public String buyTicket(Long userId) {
        return "感谢您使用12306购票，您的票号为202107171135";
    }
}
