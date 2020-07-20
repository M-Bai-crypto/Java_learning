package com.learn.object;

/**
 * @author J.M.Bai
 * @version 1.0
 * 2020/7/20
 */

// 编写一个测试类，验证你的代码.(分别创建Student对象，和Teacher对象，
//要求利用子类对象的显示初始化，即在子类构造方法中，调用父类构造方法的方式
//来初始化子类对象。)
public class Demo02 {
    public static void main(String[] args) {
        // 使用显示初始化传入四个参数创建Student对象
        Student student = new Student("Student", false, 20,10299875);
        student.displayStudent();
        // 父类中的方法不能显示子类信息
//        student.display();

        // 使用显示初始化传入四个参数创建Teacher对象
        Teacher teacher = new Teacher("Teacher",true,30,"JAVA");
        teacher.displayTeacher();
    }
}

// 声明一个Person类，里面定义了三个属性，name、gender、age（姓名、性别、年龄）
//  通过构造方法进行赋值。有一个display方法，可以展示对应的姓名性别年龄信息
class Person {
    String name;
    boolean gender;
    int age;

    public Person() {
    }

    public Person(String name, boolean gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public void display() {
        System.out.println("姓名：" + name + "，性别：" + gender + "，年龄：" + age);
    }
}

//声明一个Student类，继承自Person类，增加一个独特的属性id（学号）
// 通过构造方法进行赋值，同时有一个方法可以展示姓名性别年龄学号信息
class Student extends Person {
    private int id;

    public Student() {
    }

    public Student(String name, boolean gender, int age, int id) {
        super(name, gender, age);
        this.id = id;
    }

    public void displayStudent() {
        System.out.println("姓名：" + name + "，性别：" + gender
                + "，年龄：" + age + "，学号" + id);
    }
}

//声明一个Teacher类，继承自Person类，增加course属性（教学课程）
// 过构造方法进行赋值，有一个方法，可以显示姓名性别年龄教学课程信息
class Teacher extends Person {
    private String course;

    public Teacher() {
    }

    public Teacher(String name, boolean gender, int age, String course) {
        super(name, gender, age);
        this.course = course;
    }

    public void displayTeacher() {
        System.out.println("姓名：" + name + "，性别：" + gender
                + "，年龄：" + age + "，教学课程" + course);
    }
}