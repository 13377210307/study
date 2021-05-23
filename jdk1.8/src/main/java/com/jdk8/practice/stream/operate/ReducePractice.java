package com.jdk8.practice.stream.operate;

import com.jdk8.practice.stream.entity.Employee;
import com.jdk8.practice.stream.utils.InitEmployeesUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @Author: w
 * @Date: 2021/5/22 17:08
 */
public class ReducePractice {

    public static void main(String[] args) {
        //reduceNums();
        reduceSalary();
    }

    // 累加一个集合中的数字
    private static void reduceNums() {
        List<Integer> nums = Arrays.asList(1, 3, 5, 4, 9, 6, 6, 2, 7, 8);
        Optional<Integer> reduce = nums.stream().reduce(Integer::sum);
        System.out.println(reduce.get());
    }

    // 累加全部员工的工资
    private static void reduceSalary() {
        List<Employee> employees = InitEmployeesUtil.initEmployees();
        /*Optional<Integer> reduce = employees.stream().map(Employee::getSalary)  // 需要累加的变量
                .reduce(Integer::sum);
        System.out.println(reduce.get());*/
        Optional<Integer> reduce = employees.stream().map(Employee::getSalary)
                .reduce((sum, e) -> sum + e);
        System.out.println(reduce.get());

    }
}
