package com.learn.io02;

import java.io.*;
import java.util.Arrays;

/**
 * 2.  在一个磁盘的文件里保存26个英文小写字母（乱序），
 * 将他们读入内存中，进行排序，把排好顺序的数再重新追加写到磁盘的该文件中。
 *
 */

public class Demo02 {
    public static void main(String[] args) {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            // 读取
            fr = new FileReader("a.txt");
            char[] chars = new char[26];
            while (fr.read(chars) != -1) {
            }
            // 排序
            System.out.println("排序前：" + Arrays.toString(chars));
            Arrays.sort(chars);
            System.out.println("排序后：" + Arrays.toString(chars));
            // 写入
            fw = new FileWriter("a.txt");
            fw.write(chars);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeQuietly(fr);
            closeQuietly(fw);
        }
    }

    private static void closeQuietly(Closeable c) {
        if (c != null) {
            try {
                c.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}