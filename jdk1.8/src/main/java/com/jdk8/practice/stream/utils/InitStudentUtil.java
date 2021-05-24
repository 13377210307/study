package com.jdk8.practice.stream.utils;

import com.jdk8.practice.stream.entity.Course;
import com.jdk8.practice.stream.entity.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: w
 * @Date: 2021/5/24 10:39
 */
public class InitStudentUtil {

    public static List<Student> initStudents() {

        List<Student> students = new ArrayList<>();

        List<Course> zsCourses = new ArrayList<>();
        Course zsChinese = new Course("语文",87.0);
        zsCourses.add(zsChinese);
        Course zsMath = new Course("数学",87.0);
        zsCourses.add(zsMath);
        Course zsEnglish = new Course("英语",86.0);
        zsCourses.add(zsEnglish);

        List<Course> lsCourses = new ArrayList<>();
        Course lsChinese = new Course("语文",95.0);
        lsCourses.add(lsChinese);
        Course lsMath = new Course("数学",85.0);
        lsCourses.add(lsMath);
        Course lsEnglish = new Course("英语",75.0);
        lsCourses.add(lsEnglish);

        List<Course> wwCourses = new ArrayList<>();
        Course wwChinese = new Course("语文",90.0);
        wwCourses.add(wwChinese);
        Course wwMath = new Course("数学",80.0);
        wwCourses.add(wwMath);
        Course wwEnglish = new Course("英语",70.0);
        wwCourses.add(wwEnglish);

        List<Course> zlCourses = new ArrayList<>();
        Course zlChinese = new Course("语文",96.0);
        zlCourses.add(zlChinese);
        Course zlMath = new Course("数学",86.0);
        zlCourses.add(zlMath);
        Course zlEnglish = new Course("英语",76.0);
        zlCourses.add(zlEnglish);

        students.add(new Student("张三","三年一班",260.0, zsCourses));
        students.add(new Student("李四","三年二班",255.0, lsCourses));
        students.add(new Student("王五","三年一班",240.0, wwCourses));
        students.add(new Student("赵六","三年二班",258.0, zlCourses));
        return students;
    }



}
