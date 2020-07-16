package com.learn.method;

import java.util.Scanner;

/**
 * 判断是否素数
 * J.M.Bai
 * 2020/7/13
 */
public class Demo02 {
    public static void main(String[] args) {
        System.out.println("请输入一个整数");
        numberJudge(new Scanner(System.in).nextInt());
    }

    private static void numberJudge(int num) {
        // 添加flag，默认情况下认为是素数
        boolean flag = true;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                System.out.println(num + "不是一个素数");
                flag = false;
                break;
            }
        }
        if (flag)
            System.out.println(num + "是一个素数");
    }
}
