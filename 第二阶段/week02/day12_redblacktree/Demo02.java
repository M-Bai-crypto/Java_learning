package com.learn.day12.blackredtree.homework;

import java.util.List;

/**
 * 3(选做). 获取红黑树中小于等于给定key的最大键
 * public K floor(K key) {}
 * 获取红黑树中大于等于给定key的最小键
 * public K ceiling(K key) {}
 *
 * @author J.M.Bai
 * @version 1.0
 * @Date 2020/8/25
 */
public class Demo02 {
    public static void main(String[] args) {
        RedBlackTree<Integer, Integer> tree = new RedBlackTree<>();
        tree.put(1, 10);
        tree.put(2, 20);
        tree.put(3, 30);
        tree.put(4, 40);
        tree.put(5, 50);
        tree.put(6, 60);
        tree.put(7, 70);
        tree.put(8, 80);
        tree.put(10, 90);
        List<Integer> list = tree.levelFind();
        System.out.println("层级遍历：" + list);

        Integer floor = tree.floor(9);
        System.out.println(floor);

        Integer ceiling = tree.ceiling(9);
        System.out.println(ceiling);
    }
}
