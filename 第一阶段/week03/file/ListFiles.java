package com.learn.file;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;

/**
 * // 手写 File filter
 * @author J.M.Bai
 * @version 1.0
 * 2020/7/28
 */
public class ListFiles {
    private static File[] listFiles(File file, FileFilter fileFilter){
        // 这里不调用listFiles是因为listFiles底层也是调用的list方法，所以直接调用list
        String[] ss = file.list();
        // 如果传入的是文件直接返回null
        if (ss == null) return null;
        ArrayList<File> files = new ArrayList<>();
        for (String s : ss) {
            File f = new File(file, s);
            // 过滤器传入null时不过滤
            if (fileFilter == null || fileFilter.accept(f)){
                files.add(f);
            }
        }
        return files.toArray(new File[files.size()]);
    }
}
