package com.learn.string;

/**
 * 2. 统计大串中小串出现的次数
 * 举例：在字符串” woaijavawozhenaijavawozhendeaijavawozhendehenaijavaxinbuxinwoaijavagun”
 * 中java出现了5次
 *
 * @author J.M.Bai
 * @version 1.0
 * 2020/7/25
 */
public class Demo02 {
    public static void main(String[] args) {
        // 通过indexof判断，每次循环初始化，只要搜索结束不是-1，就持续查找
        String targetString = "woaijavawozhenaijavawozhendeaijavawozhendehenaijavaxinbuxinwoaijavagun";
        String findString = "java";
        // 存放查找结果,和统计结果
        int result = 0;
        int count = 0;
        while (result != -1) {
            // 每次的查找从当前结果加1位置开始
            result = targetString.indexOf(findString, result + 1);
            if (result != -1)
                count++;
        }
        System.out.println(findString + "出现了" + count + "次");
    }
}
