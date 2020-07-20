package com.learn.object;

/**
 * 1. 创建两个类，分别用来表示长方形和正方形，同时定义所需的成员变量，
 *    代表长方形或者正方形的边长，在两个类中分别定义两个方法，用来求对应形状的面积和周长，
 *    并定义相应的get，set方法，获取和改变方形和正方形的变长。
 * @author J.M.Bai
 * @version 1.0
 * 2020/7/20
 */
public class Demo01{
    public static void main(String[] args) {
        // 创建长方形
        Rectangle rec = new Rectangle(5,2);
        System.out.println("长方形面积为：" + rec.Area());

        // 创建正方形
        Square square = new Square(5);
        square.setLength(10);
        System.out.println("正方形周长为：" + square.perimeter());
    }
}

// 长方形
class Rectangle {
    private int length;
    private int width;

    public Rectangle(){
    }

    public Rectangle(int length, int width){
        this.length = length;
        this.width = width;
    }

    // 求面积
    public int Area(){
        return width*length;
    }

    // 求周长
    public int perimeter(){
        return 2*(length+width);
    }

    public int getLength(){
        return length;
    }

    public void setLength(int length){
        this.length = length;
    }

    public int getWidth(){
        return width;
    }

    public void setWidth(int width){
        this.width = width;
    }
}

// 正方形
class Square{
    private int length;

    public Square(){
    }

    public Square(int length){
        this.length = length;
    }

    // 求面积
    public int Area(){
        return length*length;
    }

    // 求周长
    public int perimeter(){
        return 4*length;
    }

    public int getLength(){
        return length;
    }

    public void setLength(int length){
        this.length = length;
    }
}
