package com.learn.arraytwo;

import java.util.Arrays;

/**
 * 1.输入一个 m*n的矩阵 和一个n*p的矩阵，并初始化, 要求打印出两个矩阵的乘积。
 * J.M.Bai
 * 2020/7/15
 */
public class Demo01 {
    public static void main(String[] args) {
        // 定义两个矩阵(4*2)*(2*3)
        int[][] matrix1 = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        int[][] matrix2 = {{1, 2, 3}, {4, 5, 6}};
        // 遍历结果数组，并调用方法返回乘积
        int[][] num = new int[matrix1.length][matrix2[0].length];
        // 取得第一个行的列数同时也是第二个行的列数
        int k = matrix1[0].length;
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[i].length; j++) {
                for (int t = 0; t < k; t++) {
                    // 乘积C的第m行第n列的元素等于矩阵A的第m行的元素与矩阵B的第n列对应元素乘积之和。
                    // 这里要注意，num[i][j]刚开始的初始值为0，省去了求和要定义的sum
                    num[i][j] += matrix1[i][t] * matrix2[t][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(num));
    }
}
