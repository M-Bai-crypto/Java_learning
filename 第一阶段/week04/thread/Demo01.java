package com.learn.thread;

/**
 * 1. 用多线程代码来模拟，迅雷用3个线程下载100M资源的的过程。
 *
 * @author J.M.Bai
 * @version 1.0
 * 2020/8/3
 */
public class Demo01 {
    public static void main(String[] args) {
        DownloadTask down = new DownloadTask();
        Thread thread1 = new Thread(down, "线程1");
        Thread thread2 = new Thread(down, "线程2");
        Thread thread3 = new Thread(down, "线程3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class DownloadTask implements Runnable {
    // 定义资源大小
    int size = 100;
    // 定义锁对象
    private Object lock = new Object();

    @Override
    public void run() {
        while (size > 0) {
            // 体现效果
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 同步代码块
            synchronized (lock) {
                if (size > 0) {
                    System.out.println(Thread.currentThread().getName() + "下载1M, 剩余" + --size + "M资源");
                    if(size == 0){
                        System.out.println("下载完成");
                        return;
                    }
                }

            }

        }
    }
}
