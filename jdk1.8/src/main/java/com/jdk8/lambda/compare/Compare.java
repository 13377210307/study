package com.jdk8.lambda.compare;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @Author: w
 * @Date: 2021/5/16 16:14
 * 使用lambda表达式比较两个值的大小并放入set中
 */
public class Compare {

    private void oldMethod() {
        // 通过匿名内部类实现
        Comparator<Integer> compare = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1,Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        TreeSet<Integer> ts = new TreeSet<>(compare);
    }

    private void newMethod() {
        Comparator<Integer> compare = (x,y) ->Integer.compare(x,y);
        TreeSet<Integer> ts = new TreeSet<>(compare);
    }

}
