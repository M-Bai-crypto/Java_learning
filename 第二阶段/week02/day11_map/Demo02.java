package com.learn.day10.map.homework;

import java.util.ArrayList;

/**
 * 给定一个字符串数组 words 和一个字符串 chars.
 * 如果一个字符串能被 chars 里面的字符组成，
 * 那么这个字符串就是"好"的(chars里面每个字符只能使用一次)。
 * 求：words 里面所有好的字符串的字符总个数。
 *
 * @author J.M.Bai
 * @version 1.0
 * @Date 2020/8/22
 */
public class Demo02 {
    public static void main(String[] args) {
        String[] words = {"cat", "bt", "hat", "tree"};
        String chars = "atach";
        ArrayList<String> listFather = new ArrayList<>();
        for (int i = 0; i < chars.length(); i++) {
            listFather.add(chars.charAt(i) + "");
        }
        int sum = getSum(words, listFather);
        System.out.println(sum);
    }

    /**
     * 返回题目要求的字符总个数
     *
     * @param words      查找数组
     * @param listFather 转换字符串后的集合
     * @return 返回总数
     */
    private static int getSum(String[] words, ArrayList<String> listFather) {
        ArrayList list;
        int sum = 0;
        // 开始匹配
        for (String word : words) {
            list = (ArrayList) listFather.clone();
            // 判断该字符在目标字符串中是否包含
            int i;
            String ch;
            for (i = 0; i < word.length(); i++) {
                ch = word.charAt(i) + "";
                if (list.contains(ch)) {
                    // 包含则在目标中删除该字符，继续比较
                    list.remove(ch);
                } else break;
            }
            // 出循环时i如果大于自身长度说明匹配成功
            if (i == word.length()) {
                sum += word.length();
            }
        }
        return sum;
    }
}
