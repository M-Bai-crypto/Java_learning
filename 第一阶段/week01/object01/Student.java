package com.learn.object01;

/**
 * 1.定义一个Student类：
 *
 *    a. 要求包含4个成员变量 String name, int age, boolean isMale, int sno
 *
 *    b. 分别定义5个构造方法
 *       分别为无参构造
 *      初始化name一个成员变量值的1参构造方法
 *      初始化name 和 sno两个成员变量值的2参构造方法
 *     初始化name，age，isMale三个成员变量值的3参构造方法
 *     初始化name，age， isMale，sno这4个成员变量值的4参构造方法
 *
 *    c. 在定义一个成员方法
 *       public void print() {
 *         System.out.println(name + "---" + age + "---" + (isMale ? "男" : "女") + "---" + sno);
 *      }
 * J.M.Bai
 * 2020/7/17
 */
public class Student {
    // 定义四个成员变量
    String name;
    int age;
    boolean isMale;
    int sno;
    // 无参构造
    public Student(){
    }
    // 初始化name一个成员变量值的1参构造方法
    public Student(String name){
        this.name = name;
    }
    // 初始化name，age，isMale三个成员变量值的3参构造方法
    public Student(String name, int age, boolean isMale){
        this.name = name;
        this.age = age;
        this.isMale = isMale;
    }
    // 初始化name 和 sno两个成员变量值的2参构造方法
    public Student(String name, int sno){
        this.name = name;
        this.sno = sno;
    }
    // 初始化name，age， isMale，sno这4个成员变量值的4参构造方法
    public Student(String name, int age, boolean isMale, int sno){
        this.name = name;
        this.age = age;
        this.isMale = isMale;
        this.sno = sno;
    }
    // 定义一个成员方法
    public void print(){
        System.out.println(name + "---" + age + "---"
                + (isMale ? "男" : "女") + "---" + sno);
    }
}
