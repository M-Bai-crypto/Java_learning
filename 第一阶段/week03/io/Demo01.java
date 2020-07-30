package com.learn.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 1.根据字符串特征存储单词
 * @author J.M.Bai
 * @version 1.0
 * 2020/7/29
 */
public class Demo01 {
    public static void main(String[] args) {
        String[] words = {"verb:eat", "verb:drink", "verb:sleep",
                "verb:play", "noun:rice", "noun:meat", "noun:hand", "noun:hair"};
        String verb = "";
        String noun = "";
        // 对数组中的每个元素进行筛选
        for (String word : words) {
            // 按照:对字符串进行切割
            String[] split = word.split(":");
            // verb保存到verb.txt中
            if (split[0].equals("verb")) {
                verb += split[1];
                verb += "\r\n";
            }
            // noun保存到noun.txt中
            else if (split[0].equals("noun")) {
                noun += split[1];
                noun += "\r\n";
            }
        }
        saveData(verb,noun);
    }

    // 定义方法，筛选并保存数据
    public static void saveData(String verb, String noun) {
        // 减少流对象的使用，将筛选字符串全部筛选出来一次性保存
        OutputStream osVerb = null;
        OutputStream osNoun = null;
        try {
            // 定义输出流对象
            osVerb = new FileOutputStream("verb.txt");
            osNoun = new FileOutputStream("noun.txt");
            osVerb.write(verb.getBytes());
            osNoun.write(noun.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            if (osNoun != null) {
                try {
                    osNoun.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (osVerb != null) {
                try {
                    osVerb.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
