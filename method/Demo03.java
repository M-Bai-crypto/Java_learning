package com.learn.method;

import java.util.Scanner;

/**
 * 定义一个方法，求1-99范围内的所有同构数
 * J.M.Bai
 * 2020/7/13
 */
public class Demo03 {
    public static void main(String[] args) {
        System.out.println("输入要求多少以内的同构数");
        int t = new Scanner(System.in).nextInt();
        System.out.println(t + "以内的同构数：");
        tgNumber(t);
    }

    private static void tgNumber(int t) {
        for (int i = 1; i < t; i++) {
            double num = Math.pow(i,2);
            String a = (double)i+"";
            String b = num+"";
            if (b.endsWith(a))
                System.out.println(i + "是同构数");
        }
    }
}
