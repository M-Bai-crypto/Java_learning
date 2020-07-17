package com.learn.object01;

/**
 * 3. 在定义类MyStudent(类中定义的成员变量和成员方法同Student，
 * 同时在MyStudent类中定义和Student相似的5个构造方法)的基础上，
 * 根据需要修改MyStudent相应构造方法的方法体，实现
 * MyStudent st = new MyStudent();
 * st.print();
 * 这两句代码打印出的结果是 麻花疼---100---男---1000
 * J.M.Bai
 * 2020/7/17
 */
public class Demo03 {
    public static void main(String[] args) {
        MyStudent st = new MyStudent();
        st.print();
    }
}

class MyStudent {
    // 定义四个成员变量
    String name;
    int age;
    boolean isMale;
    int sno;

    // 无参构造
    public MyStudent() {
        this("麻花疼",100,true,1000);
    }
    // 初始化name一个成员变量值的1参构造方法
    public MyStudent(String name){
        this.name = name;
    }

    // 初始化name，age，isMale三个成员变量值的3参构造方法
    public MyStudent(String name, int age, boolean isMale) {
        this.name = name;
        this.age = age;
        this.isMale = isMale;
    }

    // 初始化name 和 sno两个成员变量值的2参构造方法
    public MyStudent(String name, int sno) {
        this.name = name;
        this.sno = sno;
    }

    // 初始化name，age， isMale，sno这4个成员变量值的4参构造方法
    public MyStudent(String name, int age, boolean isMale, int sno) {
        this.name = name;
        this.age = age;
        this.isMale = isMale;
        this.sno = sno;
    }

    // 定义一个成员方法
    public void print() {
        System.out.println(this.name + "---" + this.age + "---"
                + (this.isMale ? "男" : "女") + "---" + this.sno);
    }
}
