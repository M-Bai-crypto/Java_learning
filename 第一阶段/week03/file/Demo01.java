package com.learn.file;

import java.io.File;

/**
 * 1.  递归删除目录
 *
 * @author J.M.Bai
 * @version 1.0
 * 2020/7/28
 */
public class Demo01 {
    public static void main(String[] args) {
        File file = new File("E:\\IdeaProjects\\javalearn\\firstLevel.txt");
        deleteFile(file);
    }

    // 定义删除方法
    private static void deleteFile(File file) {
        File[] files = file.listFiles();
        if (files == null){
            System.out.println("文件名错误");
            return;
        }
        for (File f : files) {
            if (f.isDirectory()) {
                // 如果是文件夹，调用删除方法
                deleteFile(f);
            }
            // 是文件直接删除
            f.delete();
        }
        // 最后删除该目录
        file.delete();
    }
}
