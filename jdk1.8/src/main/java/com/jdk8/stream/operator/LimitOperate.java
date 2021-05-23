package com.jdk8.stream.operator;

import cn.hutool.core.collection.CollectionUtil;
import com.jdk8.stream.entity.Employee;
import com.jdk8.stream.utils.EmployeeInitUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: w
 * @Date: 2021/5/14 11:21
 * 限定返回个数
 */
public class LimitOperate {

    public static void main(String[] args) {
       /* List<Integer> nums = Arrays.asList(1,1,2,3,4,5);
        List<Integer> newNums = nums.stream().limit(3).collect(Collectors.toList());
        newNums.forEach(System.out::println);*/
        limitEmployees();
    }

    // 只返回limit数量的数据，当满足了limit数量之后就不会再进行迭代查询了，可以提供效率相当于分页
    private static void limitEmployees() {
        // 初始化员工信息
        List<Employee> employees = EmployeeInitUtil.initEmployees();
        if (CollectionUtil.isNotEmpty(employees)) {
            List<Employee> newEmployees = employees.stream().filter((e) -> e.getSalary() > 5000).limit(2).collect(Collectors.toList());
            newEmployees.forEach(System.out::println);
        }
    }
}
