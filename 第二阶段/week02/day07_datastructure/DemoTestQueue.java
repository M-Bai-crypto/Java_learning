package com.learn.day07.datastructure.homework;

/**
 * 测试自定义队列
 *
 * @author J.M.Bai
 * @version 1.0
 * @Date 2020/8/18
 */
public class DemoTestQueue {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        Integer remove = queue.remove();
        System.out.println("remove :" + remove);

        Integer remove1 = queue.remove();
        System.out.println("remove :" + remove1);


        Integer element = queue.element();
        System.out.println("element = " + element);
        queue.add(6);

        System.out.println("size = " + queue.getSize());

        System.out.println("isEmpty = " + queue.isEmpty());

        System.out.println(queue);
    }
}
