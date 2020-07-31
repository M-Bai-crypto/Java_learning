package com.learn.io2;

import java.util.Scanner;

/**
 * 2. 自己利用线程的第一种实现方式，实现多线程引例
 *
 * @author J.M.Bai
 * @version 1.0
 * 2020/7/31
 */
public class Demo02 {
    public static boolean flag = true;

    public static void main(String[] args) {
        sayHello();
        closeAccept();
    }

    private static void sayHello() {
        class MyThread1 extends Thread {
            @Override
            public void run() {
                while (flag) {
                    System.out.println("你好");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        new MyThread1().start();
    }

    private static void closeAccept() {
        class MyThread2 extends Thread {
            @Override
            public void run() {
                Scanner sc = new Scanner(System.in);
                while (flag) {
                    if (sc.nextLine().equals("sleep")) {
                        flag = false;
                        break;
                    }
                }
            }
        }
        new MyThread2().start();
    }
}