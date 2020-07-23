package com.learn.object;

/**
 * @author J.M.Bai
 * @version 1.0
 * 2020/7/23
 */

// 通过调用ShowCompute类的compute(Compute com,double a, double b)方法来完成加减乘除功能
public class Demo01 {
    public static void main(String[] args) {
        // 加法，通过匿名内部类实现，定义引用变量
        Compute add = new Compute() {
            @Override
            public double compute(double a, double b) {
                return a + b;
            }
        };
        double a = 1;
        double b = 2;

        ShowCompute showCompute = new ShowCompute();
        System.out.println("加法结果：" + showCompute.compute(add, a, b));
        // 也可以使用匿名对象
        System.out.println("减法结果：" + showCompute.compute(new Compute() {
            @Override
            public double compute(double a, double b) {
                return a - b;
            }
        }, a, b));
        // 因为接口只有一个方法，是一个函数式接口，可以使用Lambda表达式传入参数
        System.out.println("乘法结果：" + showCompute.compute((i,j) -> i*j, a, b));
        System.out.println("除法结果：" + showCompute.compute((i,j) -> i/j, a, b));
    }
}

// 定义一个ShowCompute类，里面定义一个工具方法compute(Compute com,double a, double b)
class ShowCompute {
    public double compute(Compute com, double a, double b) {
        return com.compute(a, b);
    }
}

// 定义一个接口Compute，用来完成计算器的功能，比如最简单的加减乘除功能
interface Compute {
    double compute(double a, double b);
}
