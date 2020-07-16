package com.learn.array;

import java.util.Arrays;

/**
 *  给定一个数组，将数组中的元素循环向右移动 k 个位置，其中 k 是非负数。
 * J.M.Bai
 * 2020/7/14
 */
public class Demo03 {
    public static void main(String[] args) {
        int[] arr = {1,58,8,20,34,56,12};
        int moveNum = 3;
        move(arr,moveNum);
        System.out.println(Arrays.toString(arr));
    }

    /* 移动原理:先将数组反转
     将前k个元素反转
     再将后n-k个元素反转*/
    private static void move(int[] arr,int k) {
        // 每arr.length个移动是一次循环
        k %= arr.length;
        // 数组反转
        reverse(arr,0,arr.length-1);
        // 前k个元素反转
        reverse(arr,0,k-1);
        // 后n-k个元素反转
        reverse(arr,k,arr.length-1);
    }

    // 逆序的另外一种写法
    private static void reverse(int[] arr,int start,int end) {
        while (start < end) {
            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            start++;
            end--;
        }
    }
}
