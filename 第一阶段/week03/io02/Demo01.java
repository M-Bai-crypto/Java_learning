package com.learn.io02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 1.  从磁盘上读取一个文本文件（如某个java源代码），
 * * 分别统计出文件中英文字母、空格、数字字符的个数。
 * * (注意文本文件中的数字指的是数字字符！！！)
 */
public class Demo01 {
    public static void main(String[] args){
        FileReader fr = null;
        try {
            fr = new FileReader("E:\\IdeaProjects\\javalearn\\day16\\src\\morning\\Demo04.java");
            //  统计数量
            int numCount = 0;
            int spaceCount = 0;
            int wordCount = 0;
            // 逐个读取数据
            int len;
            while ((len = fr.read()) != -1) {
                // 转换为字符
                char c = (char) len;
                if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                    wordCount++;
                }
                if (c == ' ') {
                    spaceCount++;
                }
                if (c >= '0' && c <= '9') {
                    numCount++;
                }
            }
            System.out.println("英文字母：" + wordCount);
            System.out.println("空格：" + spaceCount);
            System.out.println("数字字符：" + numCount);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
