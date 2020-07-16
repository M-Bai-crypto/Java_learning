package com.learn.arraytwo;

/**
 * 2. 定义一个三维数组，并初始化之。
 * 写一个打印函数，负责打印三维数组中的数据，并测试。
 * J.M.Bai
 * 2020/7/15
 */
public class Demo02 {
    public static void main(String[] args) {
        // 定义并初始化三维数组
        int[][][] arr = new int[2][][];
        arr[0] = new int[][]{{2,8},{8,7,9},{5,6,2,7,5}};
        arr[1] = new int[][]{{1,8,2},{5}};
        // 循环打印
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                for (int t = 0; t < arr[i][j].length; t++) {
                    System.out.print(arr[i][j][t] + " ");
                }
                System.out.println();
            }
            System.out.println("--------------");
        }
    }
}
