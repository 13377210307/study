package com.jdk8.stream.operator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author: w
 * @Date: 2021/5/19 16:01
 * 创建Stream
 */
public class CreateStream {

    public static void main(String[] args) {
        createByCollections();
    }

    // 通过 java.util.Collection.stream() 方法用集合创建流
    private static void createByCollections() {
        List<String> list = Arrays.asList("a", "b", "c");
        // 创建一个顺序流
        Stream<String> stream = list.stream();
        // 创建一个并行流
        Stream<String> stream1 = list.parallelStream();

        stream.forEach(System.out::println);
        stream1.forEach(System.out::println);
    }
}
