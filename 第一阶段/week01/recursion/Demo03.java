package com.learn.recursion;

import java.util.Arrays;

/**
 * 3. 猴子第一天摘了若干个桃子，当即吃了一半，还不解馋，又多吃了一个； 、
 * 第二天，吃剩下的桃子的一半，还不过瘾，又多吃了一个；
 * 以后每天都吃前一天剩下的一半多一个，到第10天想再吃时，只剩下一个桃子了。
 * 问第i(i的取值范围为[1, 10])天的桃子个数？
 * <p>
 * f(t) = f(t-1)/2-1
 * f(t-1) = 2*f(t)+2
 * f(n) = 2*f(n+1)+2
 * f(10) = 1
 * J.M.Bai
 * 2020/7/16
 */
public class Demo03 {
    public static void main(String[] args) {
        int day = 4;
        System.out.println("第" + day + "天剩余个数为" + num(day));
    }

    // f(n) = 2*f(n+1)+2
    // f(10) = 1
    private static int num(int n) {
        // 终止条件
        if (n == 10) return 1;
        return 2 * num(n + 1) + 2;
    }
}
