package com.jdk8.stream.utils;

import com.jdk8.stream.entity.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: w
 * @Date: 2021/5/19 16:13
 */
public class PersonInitUtil {

    public static List<Person> initPersons() {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom",8900,30,"male","New York"));
        personList.add(new Person("Jack",7000,30,"male","Washington"));
        personList.add(new Person("Lily",7800,40,"female","Washington"));
        personList.add(new Person("Anni",8200,30,"female","New York"));
        personList.add(new Person("Owen",9500,50,"male","New York"));
        personList.add(new Person("Alisa",7900,60,"female","New York"));
        return personList;
    }

}
