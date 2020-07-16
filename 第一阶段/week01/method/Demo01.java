package com.learn.method;

import java.util.Scanner;

/**
 * 输出9*9乘法表
 * J.M.Bai
 * 2020/7/13
 */
public class Demo01 {
    public static void main(String[] args) {
        System.out.println("请输入要打印几行");
        multiyTable(new Scanner(System.in).nextInt());
    }

    private static void multiyTable(int num) {
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + " = " + i*j + " ");
            }
            System.out.println();
        }
    }
}
