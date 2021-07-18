package com.ticket.controller;

import com.ticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: w
 * @Date: 2021/7/17 11:28
 */
@RestController
@RequestMapping("/xiecheng")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/buyTicket/{userId}")
    public String buyTicket(@PathVariable("userId") Long userId) {
        return this.ticketService.buyTicket(userId);
    }
}
