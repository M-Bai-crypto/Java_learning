package com.learn.day10.map.homework;

/**
 * 给定两个字符串s和t, 找出那个添加字母。
 *
 * @author J.M.Bai
 * @version 1.0
 * @Date 2020/8/22
 */
public class Demo01 {
    public static void main(String[] args) {
        String s = "abcd";
        String t = "baedc";
        String ch = null;
        for (int i = 0; i < t.length(); i++) {
            ch = t.charAt(i) + "";
            if (!s.contains(ch)) {
                break;
            } else {
                ch = null;
            }
        }
        if (ch != null) System.out.println(ch);
    }
}
