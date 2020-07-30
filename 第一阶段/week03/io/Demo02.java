package com.learn.io;

import java.io.*;

/**
 * 2. 递归查找指定目录中(包括子目录中)，所有的.java文件，
 * @author J.M.Bai
 * @version 1.0
 * 2020/7/29
 */
public class Demo02 {
    public static void main(String[] args){
        // 创建文件调用方法
        findFile(new File("firstLevel"));
    }

    // 查找并保存数据
    private static void findFile(File file){
        File[] files = file.listFiles();
        if (files == null){
            System.out.println("文件名错误");
            return;
        }
        for (File f : files) {
            if (f.isDirectory()) {
                // 如果是文件夹，调用方法继续遍历
                findFile(f);
            }
            // 是.java文件保存
            if (f.getName().endsWith(".java")){
                save(f);
            }
        }
    }

    // 定义保存数据的方法
    private static void save(File file){
        InputStream in = null;
        OutputStream out = null;
        try {
            // 拿到地址，用来创建输出流
            String saveAddr = "copy file\\" + file.getName();
            // 创建输入流，输出流
            in = new FileInputStream(file);
            out = new FileOutputStream(saveAddr);
            // 使用字节数组保存
            int len;
            byte[] bytes = new byte[1024];
            while ((len = in.read(bytes)) != -1){
                out.write(bytes,0,len);
            }
            System.out.println(file.getName() + "已复制到" + saveAddr);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭流对象并释放资源
            if (in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
