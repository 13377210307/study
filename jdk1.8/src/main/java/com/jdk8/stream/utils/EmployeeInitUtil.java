package com.jdk8.stream.utils;

import com.jdk8.stream.entity.Employee;
import com.jdk8.stream.entity.Role;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: w
 * @Date: 2021/5/18 21:22
 */
public class EmployeeInitUtil {

    public static List<Employee> initEmployees() {
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Employee employee = new Employee();
            employee.setAge((i+1)*10);
            employee.setName("员工"+(i+1));
            employee.setSalary((i+1)*1000 + 3000);
            Role role = new Role();
            role.setRoleName("员工");
            role.setRoleCode("employee");
            employee.setRole(role);
            employees.add(employee);
        }
        return employees;
    }
}
