package com.jdk8.stream.operator;

import cn.hutool.core.collection.CollectionUtil;
import com.jdk8.stream.entity.Employee;
import com.jdk8.stream.utils.EmployeeInitUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: w
 * @Date: 2021/5/14 11:25
 * 跳过元素：skip中的是几就跳过几个元素
 */
public class SkipOperate {

    public static void main(String[] args) {
        /*List<Integer> nums = Arrays.asList(1,1,2,3,4,5);
        List<Integer> newNums = nums.stream().skip(3).collect(Collectors.toList());
        newNums.forEach(System.out::println);*/
        skipEmployees();
    }

    // skip(n)：跳过前n个元素
    private static void skipEmployees() {
        // 初始化员工信息
        List<Employee> employees = EmployeeInitUtil.initEmployees();
        if (CollectionUtil.isNotEmpty(employees)) {
            List<Employee> employeeList = employees.stream().skip(3).collect(Collectors.toList());
            employeeList.forEach(System.out :: println);
        }
    }
}
