package com.learn.homework_printnum;

/**
 * @author J.M.Bai
 * @version 1.0
 * 2020/8/4
 */
public class PrintTask1 implements Runnable {
    private Container container;

    // 构造方法传入同一对象
    public PrintTask1(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        while (container.getNum() <= 100) {
            synchronized (container) {
                if (!container.isPrint() || container.getNum() <= 100) {
                    // 判断线程1是否打印，没有的话打印数字,唤醒线程2打印
                    container.printNum();
                    // 打印到99就结束
                    if (container.getNum() == 100)
                        return;
                    // 打印结束后唤醒线程2
                    container.notify();
                }
                // 判断线程1是否打印，打印过了进入等待
                try {
                    container.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
