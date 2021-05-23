package com.jdk8.lambda.compare;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: w
 * @Date: 2021/5/16 16:22
 *
 * 需求：获取当前公司中员工年龄大于35的员工信息
 * 需求变更：获取当前公司中员工薪水大于5000的员工信息
 * 两个方法代码冗余
 *
 * 优化方法一：采用设计模式：策略模式
 * 缺点：每新增一个过滤就需要new一个类
 *
 * 优化方法二：采用匿名内部类方法
 * 缺点：新增一个
 *
 */
public class CompareExample {

    public static void main(String[] args) {
        List<Employee> oldEmployees = new ArrayList<>();
        initEmployees(oldEmployees);
        // 旧方法
        //List<Employee> employees = filterByAge(oldEmployees);

        // 优化方法
        // 年龄
        //List<Employee> employees = goodFilter(oldEmployees,new EmployeeAgeFilter(),35);

        // 薪水
        List<Employee> employees = goodFilter(oldEmployees,new EmployeeSalaryFilter(),9000.00);


        employees.forEach(System.out::println);
    }

    private static void initEmployees(List<Employee> employees) {
        for (int i = 0; i < 10; i++) {
            Employee employee = new Employee();
            employee.setName("员工"+(i+1)+"号");
            employee.setAge((10*i));
            employee.setSalary((double) (i * 1000 + 3000));
            employees.add(employee);
        }
    }

    // 获取年龄大于35的员工
    private static List<Employee> filterByAge(List<Employee> employees) {
        List<Employee> ems = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getAge() > 35) {
                ems.add(employee);
            }
        }
        return ems;
    }

    // 获取薪水大于5000的员工
    private static List<Employee> filterBySalary(List<Employee> employees) {
        List<Employee> ems = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getSalary() > 5000) {
                ems.add(employee);
            }
        }
        return ems;
    }

    // 优化方法一：策略设计模式
    private static List<Employee> goodFilter(List<Employee> employees, MyFilter<Employee> myFilter, Object obj) {
        List<Employee> ems = new ArrayList<>();
        for (Employee employee : employees) {
            Boolean filter = myFilter.filter(employee, obj);
            if (filter) {
                ems.add(employee);
            }
        }
        return ems;
    }

    // 优化方法二：采用匿名内部类
    private static List<Employee> innerClassFilter(List<Employee> employees, Object obj) {
        return goodFilter(employees, new MyFilter<Employee>() {
            @Override
            public Boolean filter(Employee employee, Object object) {
                return employee.getSalary() > 7000;
            }
        },obj);
    }




}
