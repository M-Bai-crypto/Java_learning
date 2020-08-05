package com.learn.homework_printnum;

/**
 * 定义缓冲区
 * @author J.M.Bai
 * @version 1.0
 * 2020/8/4
 */
public class Container {
    // 定义打印变量和打印状态
    private int num;
    private boolean flag = false;

    // 打印数字并改变状态
    public void printNum() {
        System.out.println(Thread.currentThread().getName() + "  " + num++);
        this.flag = !flag;
    }

    // 获取打印值
    public int getNum(){
        return num;
    }
    // 获取打印状态
    public boolean isPrint(){
        return flag;
    }
}
