package com.learn.day07.datastructure.homework;

import java.util.EmptyStackException;

/**
 * 使用数组实现栈
 *
 * @author J.M.Bai
 * @version 1.0
 * @Date 2020/8/18
 */
public class MyStack<E> {
    // 规定栈合法范围
    private static final int DEFAULT_STACK_SIZE = 10;
    private static final int MAX_STACK_SIZE = Integer.MAX_VALUE - 8;

    // 成员变量
    private Object[] stack;
    private int size;

    // 构造方法
    public MyStack() {
        stack = new Object[DEFAULT_STACK_SIZE];
    }

    public MyStack(int stackSize) {
        if (stackSize < 0 || stackSize > MAX_STACK_SIZE) {
            throw new IllegalArgumentException("stackSize = " + stackSize);
        }
        stack = new Object[stackSize];
    }

    /**
     * @return 返回并移除栈顶元素
     */
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E data = (E) stack[size - 1];
        stack[--size] = null;
        return data;
    }

    /**
     * 元素入栈
     *
     * @param e 指定入栈元素
     */
    public void push(E e) {
        // 扩容
        if (size == stack.length) {
            int newCapacity = newCapacity(size + 1);
            grow(newCapacity);
        }
        stack[size] = e;
        size++;
    }

    /**
     * 扩容
     *
     * @param newCapacity 新的栈容量
     */
    private void grow(int newCapacity) {
        Object[] targetArray = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            targetArray[i] = stack[i];
        }
        stack = targetArray;
    }

    /**
     * @return 返回计算得到的新容量，默认扩容1.5倍
     */
    private int newCapacity(int minCapacity) {
        int newCapacity = stack.length + (stack.length >> 1);
        if (newCapacity < 0 || newCapacity > MAX_STACK_SIZE) {
            return MAX_STACK_SIZE;
        }
        return newCapacity > minCapacity ? newCapacity : minCapacity;
    }

    /**
     * 查看栈顶元素
     *
     * @return 返回栈顶元素
     */
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (E) stack[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 返回栈内元素的
     *
     * @return 返回栈内元素的字符串表现形式
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        if (size > 0) {
            sb.append(stack[0]);
            for (int i = 1; i < size; i++) {
                sb.append("," + stack[i]);
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
