package com.learn.day07.datastructure.homework;

import java.util.NoSuchElementException;

/**
 * 使用链表实现队列
 *
 * @author J.M.Bai
 * @version 1.0
 * @Date 2020/8/18
 */
public class MyQueue<E> {
    /**
     * 节点内部类
     */
    class Node {
        Node next;
        E data;

        Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    // 成员变量
    private int size;
    private Node node;
    private Node head; // 定义头节点，方便移除

    // 构造方法
    public MyQueue() {
        head = new Node(null, null);
        node = new Node(null, null);
        head = node;
    }

    /**
     * 添加元素进入队列
     *
     * @param e 指定添加元素
     */
    public void add(E e) {
        Node newNode = new Node(e, null);
        node.next = newNode;
        node = newNode;
        size++;
    }

    /**
     * 返回队列是否为空
     *
     * @return 返回队列是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 移除队头的元素，并返回
     *
     * @return 返回队头的元素
     */
    public E remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        head = head.next;
        size--;
        return head.data;
    }

    /**
     * 查看队头的元素
     *
     * @return 返回队头的元素
     */
    public E element() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.next.data;
    }

    public int getSize() {
        return size;
    }

    /**
     * 返回队列的字符串形式
     *
     * @return 返回队列的字符串形式
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (size > 0) {
            Node node = head.next;
            while (node != null) {
                sb.append(node.data + ",");
                node = node.next;
            }
            sb.delete(sb.length() - 1, sb.length());
        }
        sb.append("]");
        return sb.toString();
    }
}
