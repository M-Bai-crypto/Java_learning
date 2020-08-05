package com.learn.homework_printnum;

/**
 * @author J.M.Bai
 * @version 1.0
 * 2020/8/4
 */
public class PrintTask2 implements Runnable {
    private Container container;

    // 构造方法传入同一对象
    public PrintTask2(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        while (container.getNum() <= 100) {
            synchronized (container) {
                // 判断线程1是否打印，已打印线程2开始打印，结束后唤醒线程1
                if (container.isPrint() || container.getNum() <= 100) {
                    container.printNum();
                    // 打印到99就结束
                    if (container.getNum() == 100){
                        return;
                    }
                    // 唤醒线程1
                    container.notify();
                }
                // 没有打印等待线程1打印
                try {
                    container.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
