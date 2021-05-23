package com.jdk8.stream.operator;

import com.jdk8.stream.entity.Person;
import com.jdk8.stream.utils.PersonInitUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: w
 * @Date: 2021/5/22 16:09
 * 拼接操作
 */
public class JoinOperate {

    public static void main(String[] args) {
        joinStr();
    }

    private static void joinStr() {
        // 初始化员工
        List<Person> peoples = PersonInitUtil.initPersons();

        // 拼接符合条件的员工的姓名  join构造方法有无参，直接连接;
        /**
         * joining() 无参：直接连接
         * joining(CharSequence delimiter)：中间用参数隔开
         * joining(CharSequence delimiter,CharSequence prefix,CharSequence suffix)：参数一：隔开符。参数二：前缀；参数三：后缀;
         * 注：前缀后后缀是拼接在连接完成后的字符串
         * start==Tom-Anni-Owen==end
         */
        String employeesName = peoples.stream()
                .filter(p -> p.getSalary() > 8000) // 筛选
                .map(p -> p.getName()) // 形成需要的数据
                .collect(Collectors.joining("-","start==","==end"));
        System.out.println(employeesName);
    }
}
