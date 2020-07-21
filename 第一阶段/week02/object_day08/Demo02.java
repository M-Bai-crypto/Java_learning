package com.learn.object;

/**
 * 2. 自己定义一个类，类中定义3个成员变量，这3个成员变量都被final修饰，
 *    请用3种不同方式，为这3个被final修饰的成员变量赋值。
 * @author J.M.Bai
 * @version 1.0
 * 2020/7/21
 */
public class Demo02 {
    public static void main(String[] args) {
        FinalVariable fv = new FinalVariable("300");
    }
}

class FinalVariable{
    //定义三个被final修饰的成员变量
    // 通过初始化语句赋值
    final int value1 = 100;

    // 通过构造代码块赋值
    final double value2;

    // 通过构造方法赋值
    final String  value3;

    // 构造代码块
    {
        value2 = 200;
    }

    // 构造方法
    public FinalVariable(String value3){
        this.value3 = value3;
        System.out.println("使用初始化语句赋值value1: " + value1);
        System.out.println("使用构造代码块赋值value2: " + value2);
        System.out.println("使用构造方法赋值value3: " + value3);
    }
}
