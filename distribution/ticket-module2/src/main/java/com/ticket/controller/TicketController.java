package com.ticket.controller;

import com.ticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: w
 * @Date: 2021/7/17 11:40
 */
@RestController
//@RequestMapping("/12306")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping
    public String buyTicket() {
        Long userId = 1L;
        return this.ticketService.buyTicket(userId);
    }

}
