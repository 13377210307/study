package com.jdk8.practice.stream.operate;

import com.jdk8.practice.stream.entity.Employee;
import com.jdk8.practice.stream.utils.InitEmployeesUtil;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: w
 * @Date: 2021/5/22 16:27
 */
public class FilterPractice {

    public static void main(String[] args) {
        //filterNums();
        //filterEmployees();
        filterManager();
    }

    // 过滤数字集合中小于5的数字并组成新的集合
    private static void filterNums() {
        List<Integer> nums = Arrays.asList(1,3,5,6,9,2,10);
        nums.stream().filter(n -> n > 5).forEach(System.out::println);
    }

    // 过滤员工工资小于5000的员工并输出他们的名字
    private static void filterEmployees() {
        List<Employee> employees = InitEmployeesUtil.initEmployees();
        employees.stream().filter(e -> e.getSalary() > 5000) // 筛选符合条件的员工
                          .map(Employee::getName)  // 组成一个新的集合
                          .forEach(System.out::println);
    }

    // 筛选年龄小于30的经理
    private static void filterManager() {
        List<Employee> employees = InitEmployeesUtil.initEmployees();
        employees.stream().filter(e -> e.getRole().equals("manager") && e.getAge() < 30)
                          .forEach(System.out::println);
    }
}
