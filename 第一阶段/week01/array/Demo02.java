package com.learn.array;

import java.util.Arrays;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，
 * J.M.Bai
 * 2020/7/14
 */
public class Demo02 {
    public static void main(String[] args) {
        int target = 10;
        int[] nums = {2,5,7,8,9,25};
        int[] result = findNum(nums, target);
        System.out.println("目标值为：" + target);
        System.out.println("数组为:" + Arrays.toString(nums));
        System.out.println("数组下标值为" + result[0] + "，" + result[1]);
    }

    private static int[] findNum(int[] nums, int target) {
        // 定义一个整型数组存放两个下标数据
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            // 这里可以优化为j = i+1,少去多余的循环
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }
}
