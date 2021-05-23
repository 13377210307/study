package com.jdk8.stream.operator;

import cn.hutool.core.collection.CollectionUtil;
import com.jdk8.stream.entity.Employee;
import com.jdk8.stream.entity.Person;
import com.jdk8.stream.utils.EmployeeInitUtil;
import com.jdk8.stream.utils.PersonInitUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: w
 * @Date: 2021/5/14 11:14
 * 过滤操作
 */
public class FilterOperate {

    public static void main(String[] args) {
        /*List<Integer> nums = Arrays.asList(1,2,3,4,5);
        List<Integer> newNums = nums.stream().filter(num -> num > 3).collect(Collectors.toList());
        if (CollectionUtil.isNotEmpty(newNums)) {
            newNums.forEach(System.out::println);
        }*/
        //employeeFilter();
        //valueFilter();
        personFilter();
    }

    // 过滤年龄大于30的员工
    private static void employeeFilter() {
        // 初始化员工
        List<Employee> employees = EmployeeInitUtil.initEmployees();
        List<Employee> newEmployees = employees.stream().filter((e) -> e.getAge() > 30).collect(Collectors.toList());
        newEmployees.forEach(System.out::println);
    }

    // 筛选数据大于6的数据
    private static void valueFilter() {
        List<Integer> list = Arrays.asList(7, 6, 9, 3, 8, 2, 1);
        list.stream().filter((x) -> x > 6).collect(Collectors.toList()).forEach(System.out::println);
    }

    //筛选员工中工资高于8000的人，并形成新的集合
    private static void personFilter() {
        List<Person> persons = PersonInitUtil.initPersons();
        persons.stream().filter(p -> p.getSalary() > 8000) // 筛选工资符合的员工
                .map(Person::getName) // 获取姓名
                .collect(Collectors.toList()).forEach(System.out :: println);
    }

}
