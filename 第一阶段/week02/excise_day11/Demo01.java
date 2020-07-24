package com.learn.excise;

/**
 * 完成对FirstLevel对象的深度克隆。
 * @author J.M.Bai
 * @version 1.0
 * 2020/7/24
 */
public class Demo01 {
    public static void main(String[] args) throws CloneNotSupportedException {
        // 最后一个被克隆的对象
        ThirdLevel thirdLevel = new ThirdLevel(100, 200);
        // 第二个被克隆的对象
        SecondLevel secondLevel = new SecondLevel(10, 20, thirdLevel);
        // 第一个被克隆的对象
        FirstLevel firstLevel = new FirstLevel(1, 2, secondLevel);
        // 调用克隆方法
        FirstLevel clone = firstLevel.clone();
        System.out.println("修改数据前的克隆数据：" + clone);

        // 修改数据
        thirdLevel.thirdIntValue = 55;
        thirdLevel.thirdDoubleValue = 66.6;
        secondLevel.secondDoubleValue = 57.8;

        System.out.println("\n修改后的数据：" + secondLevel);
        System.out.println(thirdLevel);
        System.out.println("\n修改后完成深拷贝数据并没有改变：" + clone);
    }
}

class FirstLevel implements Cloneable {
    int firstIntValue;
    double firstDoubleValue;
    SecondLevel second;

    public FirstLevel(int firstIntValue, double firstDoubleValue,
                      SecondLevel second) {
        this.firstIntValue = firstIntValue;
        this.firstDoubleValue = firstDoubleValue;
        this.second = second;
    }

    @Override
    protected FirstLevel clone() throws CloneNotSupportedException {
        //利用Object的Clone方法，
        FirstLevel first = (FirstLevel) super.clone();

        //修改 first对象中引用类型成员变量，比如 second 成员变量引用，指向被复制的那个FirstLevel对象的second对象的拷贝，
        first.second = second.clone();
        return first;
    }

    @Override
    public String toString() {
        return "FirstLevel{" +
                "firstIntValue=" + firstIntValue +
                ", firstDoubleValue=" + firstDoubleValue +
                ", second=" + second +
                '}';
    }
}

class SecondLevel implements Cloneable {
    int secondIntValue;
    double secondDoubleValue;
    ThirdLevel third;

    public SecondLevel(int secondIntValue, double secondDoubleValue,
                       ThirdLevel third) {
        this.secondIntValue = secondIntValue;
        this.secondDoubleValue = secondDoubleValue;
        this.third = third;
    }

    @Override
    protected SecondLevel clone() throws CloneNotSupportedException {
        SecondLevel clone = (SecondLevel) super.clone();
        //修改SecondLevel这个对象中，引用类型的成员变量的值，让他指向，复制之后的成员变量所指向对象地址
        clone.third = third.clone();
        return clone;
    }

    @Override
    public String toString() {
        return "\nSecondLevel{" +
                "secondIntValue=" + secondIntValue +
                ", secondDoubleValue=" + secondDoubleValue +
                ", third=" + third +
                '}';
    }
}

class ThirdLevel implements Cloneable {
    int thirdIntValue;
    double thirdDoubleValue;

    public ThirdLevel(int thirdIntValue, double thirdDoubleValue) {
        this.thirdIntValue = thirdIntValue;
        this.thirdDoubleValue = thirdDoubleValue;
    }

    @Override
    protected ThirdLevel clone() throws CloneNotSupportedException {
        // 完成最后一个对象的克隆
        return (ThirdLevel) super.clone();
    }

    @Override
    public String toString() {
        return "ThirdLevel{" +
                "thirdIntValue=" + thirdIntValue +
                ", thirdDoubleValue=" + thirdDoubleValue +
                '}';
    }
}
