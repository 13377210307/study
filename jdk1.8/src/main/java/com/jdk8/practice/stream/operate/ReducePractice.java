package com.jdk8.practice.stream.operate;

import com.jdk8.practice.stream.entity.Course;
import com.jdk8.practice.stream.entity.Employee;
import com.jdk8.practice.stream.entity.Student;
import com.jdk8.practice.stream.utils.InitEmployeesUtil;
import com.jdk8.practice.stream.utils.InitStudentUtil;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: w
 * @Date: 2021/5/22 17:08
 */
public class ReducePractice {

    public static void main(String[] args) {
        //reduceNums();
        //reduceSalary();
        //reduceStudentsScore();
        reduceClassStudentsScore();
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

    // 计算全年级学生成绩
    private static void reduceStudentsScore() {
        List<Student> students = InitStudentUtil.initStudents();
        // 计算各个学生的总分然后设置进去：
        for (Student student : students) {
            Optional<Double> reduce = student.getCourses().stream().map(Course::getScore) //组成需要计算的
                    .reduce(Double::sum);
            if (reduce.isPresent()) {
                student.setScore(reduce.get());
            }
        }

        // 计算全年级学生的成绩
        Optional<Double> reduce = students.stream()
                .map(Student::getScore) // 组成需要计算的新流
                .reduce(Double::sum);
        if (reduce.isPresent()) {
            System.out.println(reduce.get());
        }
    }

    // 计算各个班级学生成绩总和
    private static void reduceClassStudentsScore() {
        List<Student> students = InitStudentUtil.initStudents();
        HashMap<String, Object> map = new HashMap<>();
        // 先根据班级进行分组
        Map<String, List<Student>> collect = students.stream().collect(Collectors.groupingBy(Student::getClassName));

        // 根据分组后数据进行计算
        for (String key : collect.keySet()) {
            Optional<Double> reduce = students.stream().filter(student -> key.equals(student.getClassName()))  // 筛选相同班级的学生
                    .map(student -> student.getScore())
                    .reduce(Double::sum);
            if (reduce.isPresent()) {
                map.put(key,reduce.get());
            }
        }
        System.out.println(map);
    }



}
