package com.design.responseLink.example;

import lombok.Data;

/**
 * @Author: w
 * @Date: 2021/5/23 22:08
 */
@Data
public abstract class Handler {

    private Handler next;

    public Handler(Handler next) {
        this.next = next;
    }

    abstract Boolean process(Request request);


}
