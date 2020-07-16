package com.learn.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 给定一个排序数组，返回移除相同元素后数组的新长度。
 * J.M.Bai
 * 2020/7/14
 */
public class Demo01 {
    public static void main(String[] args) {
        // 给定数组
        int[] arr = {1, 85, 69, 45, 75, 23, 10, 1, 10, 85, 69};
        System.out.println("去重前数组元素为：" + Arrays.toString(arr) + ",长度为：" + arr.length);
        method01(arr);
        method02(arr);
    }

    // HashSet自动去重
    private static void method02(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        System.out.println("去重后长度为" + set.size());
    }

    // 实在水平有限,不用集合做不出来
    private static void method01(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (!list.contains(arr[i])){
                list.add(arr[i]);
            }
        }
        System.out.println("去重后长度为" + list.size());
    }
}

