package com.learn.object01;

/**
 * 2. 在第一题的基础上，创建两个Student对象分别为stu1和stu2
 *    要求stu1对象的四个成员变量name, age, isMale, sno的值分别为“张三”,18,true, 1
 *    要求stu2对象的四个成员变量name, age, isMale, sno的值分别为“李四”,25,false, 2
 *    然后在两个对象上调用print()方法即
 *    stu1.print(), stu2.print(),两次调用方法输出的结果相同吗？
 *    为什么？(提示：在方法体中访问name成员变量，直接用成员变量名name，是this.name的简写形式)
 *
 *    打印结果不同的原因：因为不同的对象存储的属性值不同，所以在调用方法时虽然是在调用同一个方法，
 *    但是调用的对象不同，属性值不同，打印结果跟随调用对象
 *
 * J.M.Bai
 * 2020/7/17
 */
public class Demo02 {
    public static void main(String[] args) {
        // “张三”,18,true, 1
        Student stu1 = new Student("张三", 18, true, 1);
        // “李四”,25,false, 2
        Student stu2 = new Student("李四", 25, false, 2);
        stu1.print();
        stu2.print();
    }
}
