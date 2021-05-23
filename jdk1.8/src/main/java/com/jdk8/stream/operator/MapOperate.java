package com.jdk8.stream.operator;

import com.jdk8.stream.entity.Employee;
import com.jdk8.stream.entity.Person;
import com.jdk8.stream.utils.EmployeeInitUtil;
import com.jdk8.stream.utils.PersonInitUtil;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: w
 * @Date: 2021/5/18 22:34
 * Stream中的map操作
 */
public class MapOperate {

    public static void main(String[] args) {
        //getEmployeeName();
        //updateStrAndNum();
        //updateEmployeeSalary();
        //addEmployeeSalary();
        Person person = new Person("测试员工1号",9000,23,"测试地区","男");

        // 获取私有变量
        Field field;
        try {
            field = person.getClass().getDeclaredField("name");
            // 允许访问私有变量
            field.setAccessible(true);
            // 设置值
            try {
                field.set(person,"修改之后的员工名称");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        System.out.println(person.getName());
    }

    // 获取员工的名字并放到集合中
    private static void getEmployeeName() {
        // 初始化员工集合
        List<Employee> employees = EmployeeInitUtil.initEmployees();
        employees.stream().map(Employee::getName).collect(Collectors.toList()).forEach(System.out :: println);
    }

    // 英文字符串数组的元素全部改为大写。整数数组每个元素+3。
    private static void updateStrAndNum() {
        String[] strArr = { "abcd", "bcdd", "defde", "fTr" };
        Arrays.stream(strArr).map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);

        List<Integer> numList = Arrays.asList(1, 3, 5, 7, 9, 11);
        numList.stream().map(x -> x+3).collect(Collectors.toList()).forEach(System.out::println);
    }

    // 为员工提工资
    private static void updateEmployeeSalary() {
        // 初始化员工集合
        List<Person> peoples = PersonInitUtil.initPersons();
        peoples.stream().map(p -> p.getSalary() + 4000).collect(Collectors.toList()).forEach(System.out::println);
    }

    // 为员工提工资
    private static void addEmployeeSalary() {
        // 初始化员工集合
        List<Person> peoples = PersonInitUtil.initPersons();

        List<Person> collect = peoples.stream().map(p -> {
            p.setSalary(p.getSalary() + 1000);
            return p;
        }).collect(Collectors.toList());

        for (Person person : collect) {
            System.out.println(person);
        }
    }

    private static void mergeStrings() {
        List<String> list = Arrays.asList("m,k,l,a", "1,3,5,7");

    }

}
