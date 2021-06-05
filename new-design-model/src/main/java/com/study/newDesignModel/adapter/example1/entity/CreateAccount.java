package com.study.newDesignModel.adapter.example1.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: w
 * @Date: 2021/6/4 9:07
 */
public class CreateAccount {

    private String number;      // 开户编号

    private String address;     // 开户地

    private Date accountDate;   // 开户时间

    private String desc;        // 开户描述

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getAccountDate() {
        return accountDate;
    }

    public void setAccountDate(Date accountDate) {
        this.accountDate = accountDate;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}