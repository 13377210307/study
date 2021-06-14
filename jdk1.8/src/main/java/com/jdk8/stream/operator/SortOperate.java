package com.jdk8.stream.operator;

import cn.hutool.core.collection.CollectionUtil;
import com.jdk8.stream.entity.Employee;
import com.jdk8.stream.entity.Person;
import com.jdk8.stream.utils.EmployeeInitUtil;
import com.jdk8.stream.utils.PersonInitUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: w
 * @Date: 2021/5/18 22:44
 * 排序操作
 */
public class SortOperate {

    public static void main(String[] args) {
        //sortEmployees();
        //sortPersons();
        //sortEmployee();
        sortedEmployees();
    }

    // 先根据年龄排，年龄一样根据姓名排
    private static void sortEmployees() {
        List<Employee> employees = EmployeeInitUtil.initEmployees();
        employees.stream().sorted((e1 , e2) -> {
            if (e1.getAge().equals(e2.getAge())) {
                // 按照姓名排
                return e1.getName().compareTo(e2.getName());
            }else {
                return e1.getAge().compareTo(e2.getAge());
            }
        }).forEach(System.out::println);
    }

    // 先根据员工工资进行排序，后根据年龄排序
    private static void sortPersons() {
        // 初始化员工集合
        List<Person> peoples = PersonInitUtil.initPersons();
        peoples.stream().sorted((p1,p2) -> {
            if (p1.getSalary() == p2.getSalary()) {
                return p1.getAge().compareTo(p2.getAge());
            }else {
                return p1.getSalary().compareTo(p2.getSalary());
            }
        }).forEach(System.out::println);
    }

    // 现根据员工工资排序，然后再根据员工姓名排序
    private static void sortEmployee() {
        // 初始化员工集合
        List<Person> persons = PersonInitUtil.initPersons();
        if (CollectionUtil.isNotEmpty(persons)) {
            persons.stream().sorted((p1,p2) -> {
               if (p1.getSalary().equals(p2.getSalary())) {
                   return p1.getName().compareTo(p2.getName());
               }else {
                   return p1.getSalary().compareTo(p2.getSalary());
               }
            }).forEach(System.out::println);
        }
    }

    // 员工工资降序，员工姓名升序
    private static void sortedEmployees() {
        // 初始化员工集合
        List<Person> persons = PersonInitUtil.initPersons();
        if (CollectionUtil.isNotEmpty(persons)) {
            persons.stream().sorted((p1,p2) -> {
                if (p1.getSalary().equals(p2.getSalary())) {
                    return p1.getName().compareTo(p2.getName());
                }else {
                    return p2.getSalary().compareTo(p1.getSalary());
                }
            }).forEach(System.out::println);
        }
    }

}
