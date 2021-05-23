package com.design.responseLink.example;

/**
 * @Author: w
 * @Date: 2021/5/23 22:10
 */
public class LoginHandler extends Handler {

    public LoginHandler(Handler next) {
        super(next);
    }

    @Override
    Boolean process(Request request) {
        System.out.println("登陆控制....");
        if (request.getFrequentOk()) {
            Handler next = getNext();
            if (null == next) {
                return true;
            }
            if (!next.process(request)) {
               return false;
            }else {
                return true;
            }
        }
        return false;
    }
}
