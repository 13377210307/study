package com.jdk8.stream.operator;

import com.jdk8.stream.entity.Person;
import com.jdk8.stream.utils.PersonInitUtil;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @Author: w
 * @Date: 2021/5/20 11:36
 * 聚合操作
 * 最大、最小、数量
 */
public class AggregateOperate {

    public static void main(String[] args) {
        //findMaxLengthString();
        //findMaxValue();
        //findMaxSalaryEmployee();
        findValueCount();
    }

    // 获取最大长度的字符串
    private static void findMaxLengthString() {
        List<String> list = Arrays.asList("adnm", "admmt", "pot", "xbangd", "weoujgsd");
        Optional<String> max = list.stream().max(Comparator.comparing(String::length));
        System.out.println(max.get());

    }
    // 获取最大值
    private static void findMaxValue() {
        List<Integer> list = Arrays.asList(7, 6, 9, 4, 11, 6);
        // 自然排序
        Optional<Integer> max = list.stream().max(Integer::compareTo);
        System.out.println(max.get());

        // 自定义排序
        Optional<Integer> max1 = list.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(max1.get());
    }

    // 获取员工工资最高的人
    private static void findMaxSalaryEmployee() {
        List<Person> peoples = PersonInitUtil.initPersons();
        /*Optional<Integer> max = peoples.stream()
                .map(p -> p.getSalary()) // 获取需要比较的字段
                .max(Integer::compareTo);// 比较*/
        Optional<Person> max = peoples.stream().max(Comparator.comparingInt(Person::getSalary));
        System.out.println(max.get());
    }

    //计算Integer集合中大于6的元素的个数。
    private static void findValueCount() {
        List<Integer> list = Arrays.asList(7, 6, 4, 8, 2, 11, 9);
        long count = list.stream().filter(l -> l > 6).count();
        System.out.println(count);
    }

}
