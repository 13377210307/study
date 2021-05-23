package com.jdk8.practice.stream.operate;

import com.jdk8.practice.stream.entity.Employee;
import com.jdk8.practice.stream.utils.InitEmployeesUtil;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: w
 * @Date: 2021/5/22 16:43
 */
public class SortPractice {

    public static void main(String[] args) {
        //sortNums();
        //consumerEmployee();
        sortEmployeeSalary();
    }

    // 对一个数字集合进行自然排列
    private static void sortNums() {
        List<Integer> nums = Arrays.asList(1, 3, 5, 4, 9, 6, 6, 2, 7, 8);

        nums.stream()
                .sorted().forEach(System.out::println);
    }

    // 对一个数字集合进行降序排列
    private static void sortConsumeNums() {
        List<Integer> nums = Arrays.asList(1, 3, 5, 4, 9, 6, 6, 2, 7, 8);

    }

    // 先对员工的工资进行排序，员工工资相同对年龄排序并返回员工姓名
    private static void consumerEmployee() {
        // 初始化员工
        List<Employee> employees = InitEmployeesUtil.initEmployees();
        employees.stream().sorted((e1,e2) -> {
            if (e1.getSalary() == e2.getSalary()) {
               return e1.getAge().compareTo(e2.getAge());
            }else {
                return e1.getSalary().compareTo(e2.getSalary());
            }
        }).map(e -> e.getName()).forEach(System.out::println);
    }

    // 对员工工资降序排列
    private static void sortEmployeeSalary() {
        // 初始化员工
        List<Employee> employees = InitEmployeesUtil.initEmployees();
        employees.stream().sorted((e1,e2) -> e2.getSalary() - e1.getSalary()).forEach(System.out::println);
    }
}
