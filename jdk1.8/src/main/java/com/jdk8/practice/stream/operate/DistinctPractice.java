package com.jdk8.practice.stream.operate;

import com.jdk8.practice.stream.entity.Employee;
import com.jdk8.practice.stream.utils.InitEmployeesUtil;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: w
 * @Date: 2021/5/22 17:17
 */
public class DistinctPractice {

    public static void main(String[] args) {
        //distinctNums();
        distinctEmployees();
    }

    // 对某个数字集合进行去重
    private static void distinctNums() {
        List<Integer> nums = Arrays.asList(1, 3, 5, 4, 9, 6, 6, 2, 7, 8);
        nums.stream().distinct().forEach(System.out::println);
    }

    // 对员工进行去重
    private static void distinctEmployees() {
        List<Employee> employees = InitEmployeesUtil.initEmployees();
        employees.add(new Employee("张三",18,3000,"employee"));
        System.out.println("未去重前============");
        employees.stream().map(Employee::getName).forEach(System.out::println);

        System.out.println("去重之后============");
        employees.stream().distinct().map(Employee::getName).forEach(System.out::println);


    }
}
