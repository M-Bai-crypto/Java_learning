package com.learn.homework_printnum;

/**
 * 创建2个线程，打印从0到99这100个数字，要求线程交叉顺序打印。
 *
 * @author J.M.Bai
 * @version 1.0
 * 2020/8/4
 */
public class Test {
    public static void main(String[] args) {
        // 定义锁对象
        Container container = new Container();
        // 创建Runnable实现类对象
        PrintTask1 printTask1 = new PrintTask1(container);
        PrintTask2 printTask2 = new PrintTask2(container);
        // 启动线程
        new Thread(printTask1,"线程1").start();
        new Thread(printTask2,"线程2").start();
    }
}
