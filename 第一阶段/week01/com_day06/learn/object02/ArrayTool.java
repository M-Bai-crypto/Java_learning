package com.learn.object02;

/**
 * 2. 写一个数组的工具类ArrayTool, 要求提供
 * 遍历，求最大值，最小值，逆置数组元素，
 * 查表(在数组中查找指定元素，若不存在，待查找元素返回-1，若存在返回元素在数组中首次出现的位置)，
 * 找元素在int类型数组(int[])中最后出现的索引等操作。

 * 2020/7/18
 * 最后结果均经过测试，没有问题
 */
public class ArrayTool {
    // 遍历
    public static void foreach(int[] ints) {
        System.out.print("[");
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]);
            // 如果是最后一个元素跳过不打印"，"
            if (i == ints.length - 1) break;
            System.out.print(", ");
        }
        System.out.println("]");
    }

    // 求最大值
    public static int max(int[] ints) {
        int max = ints[0];
        for (int anInt : ints) {
            if (anInt > max)
                max = anInt;
        }
        return max;
    }

    // 求最小值
    public static int min(int[] ints) {
        int min = ints[0];
        for (int anInt : ints) {
            if (anInt < min)
                min = anInt;
        }
        return min;
    }

    // 逆置数组元素
    public static int[] reverse(int[] ints) {
        int low = 0;
        int high = ints.length - 1;
        while (low < high) {
            int temp = ints[low];
            ints[low] = ints[high];
            ints[high] = temp;
            low++;
            high--;
        }
        return ints;
    }

    // 查表
    public static int findIndex(int element, int[] ints) {
        // 查找不到返回-1
        int index = -1;
        for (int i = 0; i < ints.length; i++) {
            if (element == ints[i]) return i;
        }
        return index;
    }

    // 找元素在int类型数组(int[])中最后出现的索引等操作
    public static int findLastIndex(int element, int[] ints) {
        // 初始为-1
        int lastIndex = -1;
        for (int i = 0; i < ints.length; i++) {
            if (element == ints[i]) lastIndex = i;
        }
        return lastIndex;
    }
}
