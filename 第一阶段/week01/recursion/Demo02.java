package com.learn.recursion;

/**
 * 2. 计算n条直线最多能把平面分成多少部分？ n >= 1
 * 线段分割原理：
 * 要切割到最多的平面，需要新增的第n条线与之前的线全部相交，这样可以产生n-1个交点
 * 第n条线产生的交点可以将线分为2条射线和n-2个线段，每条射线和线段将原来的平面分为两部分，即2+(n-2)
 * 推导可得n条线就可新增n个区域，加上n-1的部分就为n条线最多可以把平面分成的数
 *
 * 递推公式为f(n) = f(n-1)+n
 *
 * 对该公式进行归纳f(n) = f(n-1)+n
 * f(n-1)=f(n-2)+n-1
 * ......
 * f(1)=f(0)+1;
 * f(0)=1;f(0)即为没有线
 *
 * f(n) = 1+1+2+...+n
 * 可得归纳公式为：
 * f(n) = 1+n*(n+1)/2
 *
 * J.M.Bai
 * 2020/7/16
 */
public class Demo02 {
    public static void main(String[] args) {
        // n存放线的条数
        int n = 6;
        // 递归方法计算
        int num = divide(n);
        // 采用归纳公式计算
//        int num = 1 + n*(n+1)/2;
        System.out.println(n + "条线最多把平面分成" +num + "部分");
    }

    // 采用递归算法
    public static int divide(int n){
        // 结束条件为1条线时分为两部分
        if (n == 1) return 2;
        return divide(n-1) + n;
    }
}
