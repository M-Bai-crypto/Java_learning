package com.learn.io2;

import java.io.*;

/**
 * 1.复制目录
 *
 * @author J.M.Bai
 * @version 1.0
 * 2020/7/31
 */
public class Demo01 {
    // 定义复制的复制的目的地
    static String destName = "e:";

    public static void main(String[] args) {
        File file = new File("dir");
        findAll(file);
    }

    // 递归遍历查找所有文件
    private static void findAll(File file) {
        File[] list = file.listFiles();
        if (list == null) {
            System.out.println("目录错误");
            return;
        }
        for (File f : list) {
            if (f.isDirectory()) {
                // 如果是目录创建一份相同目录，继续查找
                copyDir(f);
                findAll(f);
            }
            // 不是目录就是文件，找出来.java文件复制一份
            if (f.getName().endsWith(".java")) {
                copyFile(f);
            }
        }
    }

    // 对目录进行复制
    private static void copyDir(File file) {
        String name = destName + "\\" + file.getPath();
        System.out.println("创建文件夹" + name);
        // 创建文件夹
        new File(name).mkdirs();
    }

    // 对.java文件进行复制
    private static void copyFile(File file) {
        // 获取文件名
        String name = destName + "\\" + file.getPath();
        System.out.println("复制文件到：" + name);
        // 使用缓冲字符流写入
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(file));
            bw = new BufferedWriter(new FileWriter(name));
            String s;
            while ((s = br.readLine()) != null) {
                bw.write(s);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeQuietly(br);
            closeQuietly(bw);
        }
    }

    // 关闭资源
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
