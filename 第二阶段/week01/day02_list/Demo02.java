package com.learn.day02.list.homework;

import java.util.ArrayList;
import java.util.List;

/**
 * 用 List 存储一些字符串，去除里面重复的字符串，只保留一个。
 * @author J.M.Bai
 * @version 1.0
 * @Date 2020/8/12
 */
public class Demo02 {
    public static void main(String[] args) {
        List<String > list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("c");
        list.add("d");
        System.out.println("删除前" + list);

        // 每个元素都向后查找，有重复删除
        for (int i = 0; i < list.size(); i++) {
            int j = i + 1;
            while (j < list.size()){
                if (list.get(i) == list.get(j)){
                    list.remove(j);
                }else {
                    j++;
                }
            }
        }
        System.out.println("删除后" + list);
    }
}
