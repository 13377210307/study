package com.jdk8.practice.stream.operate;

import com.jdk8.practice.stream.entity.Employee;
import com.jdk8.practice.stream.entity.Student;
import com.jdk8.practice.stream.utils.InitEmployeesUtil;
import com.jdk8.practice.stream.utils.InitStudentUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: w
 * @Date: 2021/5/22 16:43
 */
public class SortPractice {

    public static void main(String[] args) {
        //sortNums();
        //consumerEmployee();
        //sortEmployeeSalary();
        //sortStudentScore();
        sortClassStudentScore();
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

    // 对学生成绩总和进行降序排列
    private static void sortStudentScore() {
        List<Student> students = InitStudentUtil.initStudents();
        students.stream()
                .sorted((s1,s2) -> s2.getScore().compareTo(s1.getScore()))
                .forEach(System.out::println);
    }

    // 对各个班级的学生成绩总和进行降序排序
    private static void sortClassStudentScore() {
        Map<String,Object> map = new HashMap<>();
        List<Student> students = InitStudentUtil.initStudents();
        // 将学生根据班级进行分组
        Map<String, List<Student>> collect = students.stream()
                .collect(Collectors.groupingBy(Student::getClassName));

        for (String key : collect.keySet()) {
            // 排序
            List<Student> newStudents = students.stream().filter(student -> key.equals(student.getClassName()))
                    .sorted((s1, s2) -> s2.getScore().compareTo(s1.getScore())).collect(Collectors.toList());
            map.put(key,newStudents);
        }

        System.out.println(map);
    }
}
