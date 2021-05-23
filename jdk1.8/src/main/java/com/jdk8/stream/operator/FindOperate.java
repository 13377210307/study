package com.jdk8.stream.operator;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @Author: w
 * @Date: 2021/5/19 16:16
 */
public class FindOperate {

    public static void main(String[] args) {
        //findFirstValues();
        findAnyValues();
    }

    // 查询符合条件的第一个元素
    private static void findFirstValues() {
        List<Integer> list = Arrays.asList(7, 6, 9, 3, 8, 2, 1);
        // 查找集合中的大于6的第一个元素
        Optional<Integer> first = list.stream().filter(x -> x > 6).findFirst();
        System.out.println(first);
    }

    // 查询任意一个元素
    private static void findAnyValues() {
        List<Integer> list = Arrays.asList(7, 6, 9, 3, 8, 2, 1);
        // 可以通过并行流去查询
        Optional<Integer> any = list.parallelStream().filter(x -> x > 2).findAny();
        System.out.println(any);
    }


}
