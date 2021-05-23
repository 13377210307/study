package com.jdk8.stream.operator;

import com.jdk8.stream.entity.Person;
import com.jdk8.stream.utils.PersonInitUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: w
 * @Date: 2021/5/20 18:15
 * 收集操作
 */
public class CollectOperate {

    public static void main(String[] args) {
        collectValue();
    }

    // toList、toSet和toMap
    private static void collectValue() {
        List<Person> people = PersonInitUtil.initPersons();

        // 转成map
        Map<String, Person> map = people.stream().filter(p -> p.getSalary() > 8000).collect(Collectors.toMap(p -> p.getName(), p -> p));
        System.out.println(map);
        System.out.println("===========================");


        people.add(new Person("Tom",8900,30,"male","New York"));
        // 转成Set
        people.stream().filter(p -> p.getSalary() > 8000).collect(Collectors.toSet()).forEach(System.out::println);
        System.out.println("===========================");

        // 转成List
        people.stream().filter(p -> p.getSalary() > 8000).collect(Collectors.toList()).forEach(System.out::println);


    }
}
