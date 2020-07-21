package com.learn.object;

/**
 * 3. 实现如下多态案例，分别定义Person类，SouthPerson(表示南方人)，NorthPerson(表示北方人)
 * @author J.M.Bai
 * @version 1.0
 * 2020/7/21
 */
public class Demo03 {
    public static void main(String[] args) {
        Person person = new Person();
        // 父类方法
        person.eat();

        // 父类引用指向南方人
        Person southPerson = new SouthPerson();
        southPerson.eat();

        // 父类引用指向北方人
        Person northPerson = new NorthPerson();
        northPerson.eat();
    }
}

// Person类
class Person{
    public void eat(){
        System.out.println("人要吃饭");
    }
}

// SouthPerson(表示南方人)
class SouthPerson extends Person{
    @Override
    public void eat(){
        System.out.println("南方人吃炒菜和米饭");
    }
}

// NorthPerson(表示北方人)
class NorthPerson extends Person{
    @Override
    public void eat(){
        System.out.println("北方人吃烩菜和馒头");
    }
}
