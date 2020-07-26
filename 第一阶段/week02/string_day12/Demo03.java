package com.learn.string;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 注意：如果有多个最长回文串，返回其中一个即可
 * @author J.M.Bai
 * @version 1.0
 * 2020/7/25
 */
public class Demo03 {
    public static void main(String[] args) {
        // 查找字符串
        String str = "ababcdbaba";
        System.out.println(find(str));
    }

    // 查找并输出与该字符相关的回文串
    private static String find(String str) {
        if (str == null) return null;

        if (str.length() == 1) return str;

        String longestPalindrome = "";

        for (int i = 0; i < str.length(); i++) {
            // 查找以i字符为对称轴的回文串，单轴旋转
            String result = getResult(str, i, i);
            if (result.length() > longestPalindrome.length())
                longestPalindrome = result;

            // 查找以i和i+1为对称轴的回文串，双轴
            result = getResult(str, i, i + 1);
            if (result.length() > longestPalindrome.length())
                longestPalindrome = result;
        }

        return longestPalindrome;
    }

    // s为待查询字符串
    // [0,l] 查询字符串左边
    //[h,s.length()-1] 查询字符串右边
    private static String getResult(String s, int l, int h) {
        char[] chars = s.toCharArray();
        while (l >= 0 && h < s.length() && chars[l] == chars[h]) {
            l--;
            h++;
        }
        l++;
        h--;
        // 返回l开始，h-l+1个字符
        return new String(chars, l, h - l + 1);
    }
}
