package com.jdk8.lambda.compare;

/**
 * @Author: w
 * @Date: 2021/5/16 16:42
 * 员工年龄过滤
 */
public class EmployeeSalaryFilter implements MyFilter<Employee> {

    @Override
    public Boolean filter(Employee employee,Object object) {
        return employee.getSalary() > (Double) object;
    }
}
