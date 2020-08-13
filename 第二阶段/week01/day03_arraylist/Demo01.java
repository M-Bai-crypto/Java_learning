package com.learn.day03.arraylist.homework;

import java.util.ArrayList;

/**
 * 使用ArrayList来实现一个栈的数据结构（先进后出）
 *
 * @author J.M.Bai
 * @version 1.0
 * @Date 2020/8/13
 */
public class Demo01 {
    public static void main(String[] args) {
        StackAchieve<String> stack = new StackAchieve();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        String peek = stack.peek();
        System.out.println(peek);

        String pop = stack.pop();
        System.out.println(pop);
        System.out.println(stack.isEmpty());
    }
}


// ArrayList实现栈
class StackAchieve<T> {
    ArrayList<T> list = new ArrayList();
    // 定义栈顶位置
    private int num = list.size() - 1;

    // 出栈
    public T pop() {
        if (num >= 0) {
            T remove = list.remove(num);
            num--;
            return remove;
        }
        return null;
    }

    // 入栈
    public boolean push(T t) {
        try {
            list.add(t);
            num++;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // 查看
    public T peek() {
        if (num >= 0) {
            return list.get(num);
        }
        return null;
    }

    // 是否为空
    public boolean isEmpty() {
        return list.isEmpty();
    }
}