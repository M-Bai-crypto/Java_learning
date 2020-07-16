package com.learn.arraytwo;

import java.util.Arrays;

/**
 * 对Demo03的重构
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * 本次采用矩阵边界限定，每次查找一个元素，碰到边界改变方向
 * J.M.Bai
 * 2020/7/16
 */
public class Demo04 {
    public static void main(String[] args) {
        // 给定一个矩阵
        // (以下均为测试用数组)
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6,}, {7, 8, 9}};
        int[][] matrix = {{1, 2, 3, 4,5, 6}, {7, 8,9, 10, 11, 12}};
//        int[][] matrix = {{1, 2}, {6, 7}, {11,12}, {16, 17}, {21, 22}, {26, 27}, {31, 32}};
        System.out.println("原数组：" + Arrays.deepToString(matrix));
        int[] result = sprialMarix(matrix);
        System.out.println("螺旋打印结果：" + Arrays.toString(result));
    }

    private static int[] sprialMarix(int[][] matrix) {
        // 判断是否为空
        if (matrix.length == 0) return new int[0];
        // 定义数组元素总数量
        int totalCount = matrix.length * matrix[0].length;
        // 数组用来接收结果
        int[] result = new int[totalCount];
        // 定义边界限定
        int right = matrix[0].length - 1;
        int left = 0;
        int top = 0;
        int bottom = matrix.length - 1;
        // 用来存储方向的数组
        int[] direction = {0, 1};
        /*
        关于数组中两个元素的说明
        (0,1) 行不变，列+
        (0,-1) 行不变，列-
        (1,0) 列不变，行+
        (-1,0) 列不变，行-
         */
        // 接收数组索引值初始化
        int index = 0;
        // 遍历数组行和列初始化
        int row = 0;
        int column = 0;
        while (totalCount > 0) {
            // 获取元素,索引递增
            result[index++] = matrix[row][column];
            // 总数递减
            totalCount--;
            // 通过选择结构判断元素是否到达边界
            if (row == top && column == right && direction[1] == 1){
                direction[0] = 1;
                direction[1] = 0;
                top++;
            }else if (row == bottom && column == right && direction[0] == 1){
                direction[0] = 0;
                direction[1] = -1;
                right--;
            } else if (row == bottom && column == left && direction[1] == -1) {
                direction[0] = -1;
                direction[1] = 0;
                bottom--;
            } else if (row == top && column == left && direction[0] == -1) {
                direction[0] = 0;
                direction[1] = 1;
                left++;
            }
            // 改变下一个元素的行和列
            row += direction[0];
            column += direction[1];
        }
        return result;
    }
}
