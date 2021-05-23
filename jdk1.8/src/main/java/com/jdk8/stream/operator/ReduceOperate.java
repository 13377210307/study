package com.jdk8.stream.operator;

import com.jdk8.stream.entity.Person;
import com.jdk8.stream.utils.PersonInitUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @Author: w
 * @Date: 2021/5/19 15:41
 * 从流中计算某个值，接受一个二元函数作为累积器，从前两个元素开始持续应用它，累积器的中间结果作为第一个参数，流元素作为第二个参数
 */
public class ReduceOperate {

    public static void main(String[] args) {
        //reduceValue();
        //reduceOperateForValue();
        reduceOperateForEmployees();
    }

    private static void reduceValue() {
        List<Integer> values = Arrays.asList(1,2,3,4,5);
        Integer reduce = values.stream().reduce(1, (sum, y) -> sum + y);
        System.out.println(reduce);
    }

    // 求Integer集合的元素之和、乘积和最大值。
    private static void reduceOperateForValue() {
        // 方式一
        List<Integer> list = Arrays.asList(1, 3, 2, 8, 11, 4);
        // sum,y分别代表之前计算的值和集合中的每个值
        Optional<Integer> reduce = list.stream().reduce((sum, y) -> sum + y);
        System.out.println(reduce.get());

        // 表示计算集合中integer的总和
        Integer integer = list.stream().reduce(Integer::sum).get();
        System.out.println(integer);

        // 方式三：0表示起始值为0，若为2的话就是：2+1+3+2+8+11+4
        Integer reduce1 = list.stream().reduce(0, (sum, y) -> sum + y);
        System.out.println(reduce1);

        // 求乘积方式一
        Integer reduce2 = list.stream().reduce(1, (mul, y) -> mul * y);
        System.out.println(reduce2);

        // 求最大值
        Optional<Integer> reduce3 = list.stream().reduce(Integer::max);
        System.out.println(reduce3.get());
    }

    // 求所有员工工资之和和工资最大值
    private static void reduceOperateForEmployees() {
        // 初始化员工
        List<Person> people = PersonInitUtil.initPersons();

        // 方式一
        Optional<Integer> reduce = people.stream().map(p -> p.getSalary()).reduce(Integer::sum);
        System.out.println(reduce.get());

        // 方式二
        Integer integer = people.stream().map(p -> p.getSalary()).reduce((sum, p) -> sum + p).get();
        System.out.println(integer);

        // 获取最高工资：
        Integer max1 = people.stream().map(p -> p.getSalary()).reduce(Integer::max).get();
        System.out.println(max1);

    }
}
