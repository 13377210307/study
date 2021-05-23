package com.jdk8.stream.operator;

import com.jdk8.stream.entity.Employee;
import com.jdk8.stream.utils.EmployeeInitUtil;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: w
 * @Date: 2021/5/18 22:49
 * 匹配操作
 * allMatch-检查是否匹配所有元素
 * anyMatch-检查是否至少匹配一个元素
 * noneMatch-检查是否没有匹配所有元素
 */
public class MatchOperate {

    public static void main(String[] args) {
        //matchEmployee();
        isMatchValue();
    }

    private static void matchEmployee() {
        // 初始化员工信息
        List<Employee> employees = EmployeeInitUtil.initEmployees();
        boolean b1 = employees.stream().allMatch((e) -> e.getAge() == 10);
        System.out.println(b1);

        boolean b2 = employees.stream().anyMatch((e) -> e.getName().equals("员工1"));
        System.out.println(b2);

        boolean b3 = employees.stream().noneMatch((e) -> e.getName().equals("员工1"));
        System.out.println(b3);
    }

    private static void isMatchValue() {
        List<Integer> list = Arrays.asList(7, 6, 9, 3, 8, 2, 1);
        boolean match = list.parallelStream().anyMatch(x -> x > 6);
        System.out.println(match);
    }


}
