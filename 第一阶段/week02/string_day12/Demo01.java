package com.learn.string;

/**
 * 1. 判断一个字符串是否是回文串
 * 例如"abc"不是对称字符串，"aba"、"abba"、"aaa"、"mnanm"是对称字符串
 *
 * @author J.M.Bai
 * @version 1.0
 * 2020/7/25
 */
public class Demo01 {
    public static void main(String[] args) {
        // 计算字符串长度，每次进行一组比较，当结束时都为true则为回文串
        String s = "abababa";
        int first = 0;
        int last = s.length() - 1;
        while (first < last) {
            if (s.charAt(first) != s.charAt(last)) {
                System.out.println(s + "不是一个对称字符串");
                return;
            }
            first++;
            last--;
        }
        System.out.println(s + "是一个对称字符串");
    }
}
