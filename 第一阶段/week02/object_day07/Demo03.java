package com.learn.object;

/**
 * @author J.M.Bai
 * @version 1.0
 * 2020/7/20
 */

//定义一个Student类，并要求其他类在使用Student类的时候，最多只能创建10个Student类的对象，如何实现？
public class Demo03 {
    public static void main(String[] args) {
        Student1 student1 = Student1.createStudent();
        Student1 student2 = Student1.createStudent();
        Student1 student3 = Student1.createStudent();
        Student1 student4 = Student1.createStudent();
        Student1 student5 = Student1.createStudent();
        Student1 student6 = Student1.createStudent();
        Student1 student7 = Student1.createStudent();
        Student1 student8 = Student1.createStudent();
        Student1 student9 = Student1.createStudent();
        Student1 student10 = Student1.createStudent();
        Student1 student11 = Student1.createStudent();
        Student1 student12 = Student1.createStudent();
    }
}
class Student1{
    // 通过静态变量控制一个类创建对象的次数
    static int COUNT = 1;

    // 将构造方法私有
    private Student1(){}

    // 将方法定义为静态，并返回student类型
    public static Student1 createStudent(){
        if (COUNT < 11){
            Student1 student = new Student1();
            System.out.println("这是创建的第" + COUNT + "个对象");
            COUNT++;
            return student;
        }
        else {
            System.out.println("已创建"+ (COUNT-1) + "个对象，无法继续创建");
            return null;
        }
    }
}
