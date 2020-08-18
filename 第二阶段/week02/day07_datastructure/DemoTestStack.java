package com.learn.day07.datastructure.homework;

import com.learn.day07.datastructure.homework.MyStack;

/**
 * @author J.M.Bai
 * @version 1.0
 * @Date 2020/8/18
 */
public class DemoTestStack {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>(0);

        stack.push(1);
        stack.push(2);

        System.out.println(stack);

        Integer pop = stack.pop();
        System.out.println(pop);

        stack.push(3);

        Integer peek = stack.peek();
        System.out.println(peek);

        System.out.println(stack.isEmpty());

        System.out.println(stack);
    }
}
