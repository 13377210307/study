package com.jdk8.stream.operator;

import com.jdk8.stream.entity.Employee;
import com.jdk8.stream.utils.EmployeeInitUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: w
 * @Date: 2021/5/14 11:19
 * 去重操作
 */
public class DistinctOperate {

    public static void main(String[] args) {
        /*List<Integer> nums = Arrays.asList(1,1,2,3,4,5);
        List<Integer> newNums = nums.stream().distinct().collect(Collectors.toList());
        newNums.forEach(System.out::println);*/
        distinctEmployees();
    }

    // 使用distinct需要重写类的equals方法和hashCode方法
    private static void distinctEmployees() {
        // 初始化员工
        List<Employee> employees = EmployeeInitUtil.initEmployees();
        Employee employee1 = new Employee();
        employee1.setName("员工1");
        employee1.setAge(10);
        employee1.setSalary(4000);
        employees.add(employee1);

        Employee employee2 = new Employee();
        employee2.setName("员工2");
        employee2.setAge(20);
        employee2.setSalary(5000);
        employees.add(employee2);

        List<Employee> employeeList = employees.stream().distinct().collect(Collectors.toList());
        employeeList.forEach(System.out::println);


    }
}
