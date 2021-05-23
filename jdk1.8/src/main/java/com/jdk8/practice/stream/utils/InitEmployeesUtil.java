package com.jdk8.practice.stream.utils;

import com.jdk8.practice.stream.entity.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: w
 * @Date: 2021/5/22 16:32
 */
public class InitEmployeesUtil {

    public static List<Employee> initEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("张三",18,3000,"employee"));
        employees.add(new Employee("李四",20,8000,"manager"));
        employees.add(new Employee("王五",20,5000,"employee"));
        employees.add(new Employee("赵六",30,4000,"employee"));
        employees.add(new Employee("田七",30,9000,"manager"));
        return employees;
    }
}
