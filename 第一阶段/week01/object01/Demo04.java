package com.learn.object01;

/**
 *  如图所示，分别将一个double类型的数据和一个引用类型的数据传入某个方法，
 *  在方法内分别对对应的数据进行一些运算 ，
 *  经过运算之后，double类型的数据和引用类型的数据分别是什么?
 *  并解释下，为什么
 *
 *  对于打印结果的分析：经过运算之后，double类型的数据是100.00，引用类型的数据是我是马云。
 *   double数据类型是由于doubleTest方法调用时，它里面形参的数据是一份复制数据，修改后只是改变了doubleTest方法体内部的那一份，
 *   所以在doubleTest方法中的打印结果只是一份复制数据的修改结果，主方法中打印的还是原来的数据。
 *   引用类型的数据则有所不同，PersonTest形参数据的是一份复制的地址，
 *   但重点是PersonTest中复制的一份和主方法中的地址都指向对象在堆中的地址值，而堆中的这份数据本质上是同一份，
 *   所以在PersonTest中通过访问对象地址值并对其中参数进行修改是改变了堆中的原始数据，
 *   因此不管在主方法中还是PersonTest中修改后的打印结果都发生了改变
 *
 * J.M.Bai
 * 2020/7/17
 */
public class Demo04 {
    public static void main(String[] args) {
        Person p = new Person();
        p.name = "我是马化腾";
        p.age = 50;
        PersonTest(p);
        double money = 100.00;
        doubleTest(money);
        System.out.println("方法执行后的money：" + money);// 100.00
        System.out.println("方法执行后的name：" + p.name);// "我是马云"
    }

    private static void doubleTest(double money) {
        money = 200.0;
    }

    public static void PersonTest(Person person) {
        System.out.println("传入person的name：" + person.name);
        person.name = "我是马云";
        System.out.println("方法内重新赋值后的name：" + person.name);
    }

}
class Person{
    String name;
    int age;
}
