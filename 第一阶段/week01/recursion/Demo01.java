package com.learn.recursion;

/**
 *  1. 一个楼梯有n (n >= 1)级，每次走1级或两级，
 *  请问从1级台阶走到第n级台阶一共有多少种走法(假设一开始站在第0级台阶上)
 *  第1级台阶有1种走法
 *  第2级台阶有2种走法，第一次走1级或者第一次走两级
 *  ...
 *  第n级台阶考虑两种情况：
 *  第一次走1级，后面的n-1个台阶有f(n-1)种走法
 *  第一次走2级，后面的n-2个台阶有f(n-2)种走法
 *  f(n) = f(n-1) + f(n-2)
 *
 *  同样的道理还有一次可以选择走1/2/3步，要递归解决的只是第一步出去后后面的走法
 *  f(n) = f(n-1) + f(n-2) + f(n-3)
 * J.M.Bai
 * 2020/7/16
 */
public class Demo01 {
    public static void main(String[] args) {
        int n = 10;
        // 采用递归运算
//        int count = moveMethod(n);
        // 使用数组(动态规划)
        int[] temp = new int[n + 1];
        temp[1] = 1;
        temp[2] = 2;
        for (int i = 3; i < temp.length; i++) {
            temp[i] = temp[i - 1] + temp[i - 2];
        }
        int count = temp[n];
        System.out.println("从第一级走到第" + n + "级台阶一共有" + count + "种走法");
    }

    private static int moveMethod(int n) {
        if (n == 1)return 1;
        if (n == 2)return 2;
        return moveMethod(n-1) + moveMethod(n-2);
    }
}
