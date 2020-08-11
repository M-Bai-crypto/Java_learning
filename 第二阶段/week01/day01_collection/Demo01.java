package com.learn.day01.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 用Collection存储自定义对象(Student)，并遍历。
 * 删除名字是"张三"的学生。
 *
 * @author J.M.Bai
 * @version 1.0
 * @Date 2020/8/11
 */
public class Demo01 {
    public static void main(String[] args) {
        Collection<Student> stu = new ArrayList<>();
        Student stu1 = new Student("张三", 24);
        Student stu2 = new Student("李四", 18);
        Student stu3 = new Student("王五", 20);
        stu.add(stu1);
        stu.add(stu2);
        stu.add(stu3);
        stu.add(stu3);
        System.out.println("删除前：");
        for (Iterator<Student> iterator = stu.iterator(); iterator.hasNext(); ) {
            Student next = iterator.next();
            System.out.println(next);
            if ("张三".equals(next.getName())) {
                iterator.remove();
            }
        }
        System.out.println("删除后：");
        System.out.println(stu);
    }
}


class Student {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
