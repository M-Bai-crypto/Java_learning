package com.learn.object;

/**
 * 1. 为某研究所编写一个通用程序，用来计算每一种交通工具运行 1000公里所需的时间.
 *
 * @author J.M.Bai
 * @version 1.0
 * 2020/7/22
 */
public class Demo01 {
    public static void main(String[] args) {
        int distance = 1000;
        int a = 1;
        int b = 2;
        int c = 3;
        Vehicle vehicle = new Car(a, b, c);
        System.out.println("Car的时间是" + calculateTime(distance, vehicle));

        vehicle = new Plane(a, b, c);
        System.out.println("Plane的时间是" + calculateTime(distance, vehicle));

        vehicle = new Ship(a, b, c);
        System.out.println("Ship的时间是" + calculateTime(distance, vehicle));
    }

    public static double calculateTime(int distance, Vehicle vehicle) {
        return distance / vehicle.calculate();
    }
}

// 定义抽象类具有计算功能以及三个参数
abstract class Vehicle {
    final double a, b, c;
    public Vehicle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // 返回三个参数得到的速度
    public abstract double calculate();
}

// Car
class Car extends Vehicle {
    public Car(double a, double b, double c) {
        super(a, b, c);
    }

    @Override
    public double calculate() {
        return a * b / c;
    }
}

// Plane
class Plane extends Vehicle {
    public Plane(double a, double b, double c) {
        super(a, b, c);
    }

    @Override
    public double calculate() {
        return a + b + c;
    }
}

// Ship
class Ship extends Vehicle {
    public Ship(double a, double b, double c) {
        super(a, b, c);
    }

    @Override
    public double calculate() {
        return a + b / c;
    }
}
