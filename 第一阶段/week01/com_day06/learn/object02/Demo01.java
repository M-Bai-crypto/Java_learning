package com.learn.object02;

import java.util.Random;

/**
 * 1. 定义一个表示学生信息的类Student，要求如下：
 * 　（1）类Student的成员变量：
 * id表示学号；name表示姓名；gender表示性别；age表示年龄；java表示Java课程成绩。
 *    （2) 在定义一个print()方法，输出student对象的 name，gender，age，java的值(即输出学生信息)
 *
 *   （3）根据类Student的定义，创建五个该类的对象，输出每个学生的信息，计算并输出这五个学生Java语言成绩的平均值，
 *
 *        提示： 数组既可以存储基本数据类型的值，也可以存储引用数据类型的值
 *               因此，5个Student对象可以放在一个Student数组中
 *               Student[] students = new Student[5];
 *               students[1] = student对象的引用
 *
 *              //求平均值，都可以通过循环遍历 students数组来完成
 * J.M.Bai
 * 2020/7/18
 */
public class Demo01 {
    public static void main(String[] args) {
        // 存储五个学生对象
        Student[] students = new Student[5];
        // 定义一个随机数来随机姓名和成绩，帮助初始化成员信息
        Random r = new Random();
        // 定义一个变量来计算成绩平均值
        int sum = 0;

        // 偷个懒，通过循环给五个对象进行成员初始化
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student(i+1,"成员" + (i+1),
                    (i%2 == 0),r.nextInt(10)+20,r.nextInt(100));
        }
        // 遍历打印,并对成绩求和
        for (Student student : students) {
            student.print();
            sum += student.getJava();
        }

        // 计算均值并打印
        System.out.println("它们的成绩平均值是：" + sum/students.length);
    }
}
class Student{
    // id表示学号；name表示姓名；gender表示性别；age表示年龄；java表示Java课程成绩。
    private int id;
    private String name;
    private boolean gender;
    private int age;
    private double java;
    // 无参构造
    public Student(){}

    // 全参构造
    public Student(int id, String name, boolean gender, int age, double java){
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.java = java;
    }

    // 在定义一个print()方法，输出student对象的 name，gender，age，java的值(即输出学生信息)
    public void print(){
        System.out.print("学号：" + this.id);
        System.out.print("        ");
        System.out.println("姓名：" + this.name);
        System.out.print("性别：" + this.gender);
        System.out.print("        ");
        System.out.println("年龄：" + this.age);
        System.out.println("Java课程成绩：" + this.java);
        System.out.println("===========================");
    }

    // 定义一个方法获取该对象的年龄
    public double getJava(){
        return java;
    }
}

