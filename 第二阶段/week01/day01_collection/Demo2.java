package com.learn.day01.collection;

import java.util.Arrays;

/**
 * 3. 给定一个数组nums和一个值 val，你需要原地移除所有数值等于val的元素，
 * 并讲数组中不等val的值移动到数组的前面。返回移除后不等于val的元素个数。
 * 注意：
 * 原地的意思是空间复杂度为O(1)，也就是在原数组上进行修改。
 * 元素的顺序可以改变。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * @author J.M.Bai
 * @version 1.0
 * @Date 2020/8/11
 */
public class Demo2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 56, 7, 5, 4, 3, 3};
        int val = 3;
        // 记录新数组的长度
        int length = nums.length;
        System.out.println("原数组：" + Arrays.toString(nums));
        for (int i = 0; i < length; i++) {
            // 如果发现有相等元素，把最后一位拿过来替换，同时数组长度-1
            // 从当前位置再次进行比较，防止拿过来的是要移除的元素
            if (nums[i] == val) {
                nums[i] = nums[length - 1];
                length--;
                i--;
            }
        }
        System.out.println("不等于" + val + "的元素个数为：" + length);
    }
}
