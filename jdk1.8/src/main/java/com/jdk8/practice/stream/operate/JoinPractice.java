package com.jdk8.practice.stream.operate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: w
 * @Date: 2021/5/22 16:22
 */
public class JoinPractice {

    public static void main(String[] args) {
        joinStr();
    }

    //练习一：将某个集合中的字符串拼接起来并用,隔开
    private static void joinStr() {
        List<String> strs = Arrays.asList("A","B","C");
        String newStr = strs.stream().collect(Collectors.joining(","));
        System.out.println(newStr);
    }
}
