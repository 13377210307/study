package com.jdk8.practice.stream.operate;

import com.jdk8.practice.stream.entity.Employee;
import com.jdk8.practice.stream.entity.Student;
import com.jdk8.practice.stream.utils.InitEmployeesUtil;
import com.jdk8.practice.stream.utils.InitStudentUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: w
 * @Date: 2021/5/23 17:01
 */
public class GroupByPractice {

    public static void main(String[] args) {
        //employeeGroupByRoleAndAge();
        classGroupByClassName();
    }

    /**
     * 根据角色将员工进行分组
     */
    private static void employeeGroupByRole() {
        List<Employee> employees = InitEmployeesUtil.initEmployees();
        Map<String, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(Employee::getRole));
        System.out.println(collect);
    }

    /**
     * 先按角色进行分组，再按年龄进行分组
     */
    private static void employeeGroupByRoleAndAge() {
        List<Employee> employees = InitEmployeesUtil.initEmployees();
        Map<String, Map<Integer, List<Employee>>> collect = employees.stream().collect(Collectors.groupingBy(Employee::getRole, Collectors.groupingBy(Employee::getAge)));
        System.out.println(collect);
    }

    /**
     * 根据班级进行分组
     */
    private static void classGroupByClassName() {
        List<Student> students = InitStudentUtil.initStudents();
        Map<String, List<Student>> classes = students.stream().collect(Collectors.groupingBy(Student::getClassName));
        System.out.println(classes);
    }
}
