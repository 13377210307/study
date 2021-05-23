package com.design.responseLink.example;

/**
 * @Author: w
 * @Date: 2021/5/23 22:10
 */
public class FrequentHandler extends Handler {

    public FrequentHandler(Handler next) {
        super(next);
    }

    @Override
    Boolean process(Request request) {
        System.out.println("访问频率控制....");
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
