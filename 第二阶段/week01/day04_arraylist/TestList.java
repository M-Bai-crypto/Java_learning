package com.learn.day04.arraylist;

import java.util.ListIterator;

/**
 * 测试自定义集合
 *
 * @author J.M.Bai
 * @version 1.0
 * @Date 2020/8/14
 */
public class TestList {
    public static void main(String[] args) {
        // 测试构造方法
        MyArrayList<String> myArrayList = new MyArrayList<>(10);
        for (int i = 0; i < 20; i++) {
            myArrayList.add("list" + i);
        }
        System.out.println(myArrayList);

        /**
         * 集合相关API测试
         *
         */

        // index 参数合法校验
//        myArrayList.add(-1,"a");

        // clear清空
//        myArrayList.clear();

        // 移除指定位置元素
//        myArrayList.remove(100);
//        boolean remove = myArrayList.remove(null);
//        System.out.println(remove);

        // indexOf
        /*int i = myArrayList.indexOf("19");
        int i2 = myArrayList.indexOf(null);
        System.out.println(i);
        System.out.println(i2);*/

        // lastIndexOf
        /*myArrayList.set(10, "5");
        int i = myArrayList.lastIndexOf("5");
        System.out.println(i);*/

        // set
//        String set = myArrayList.set(1, null);
//        System.out.println(set);

        // contains
//        boolean contains = myArrayList.contains("5");
//        System.out.println(contains);

        // imEmpty
//        myArrayList.clear();
//        boolean empty = myArrayList.isEmpty();
//        System.out.println(empty);


        /**
         * 迭代器相关API测试
         */

        // next
        ListIterator listIterator = myArrayList.listIterator();
        for (; listIterator.hasNext(); ) {
            System.out.println(listIterator.next());
        }
//        listIterator.next();

        System.out.println("===================================");

        // previous ,顺便试试错误使用方法
        for (; listIterator.hasPrevious(); ) {
            Object previous = listIterator.previous();
            System.out.println(previous);

            // 错误使用，并未触发抛出异常
            if (previous.equals("list0")) {
                myArrayList.remove("list18");
            }
        }
//        listIterator.previous();

        // nextIndex & previousIndex

        /*int i = listIterator.nextIndex();
        System.out.println(i);

        int j = listIterator.previousIndex();
        System.out.println(j);*/

        // remove
//        listIterator.remove();
//        listIterator.remove();

        // set
//        listIterator.set("it's fine day!");

        // add
//        listIterator.add("cafe");
//        listIterator.add("Baby");

        /**
         * 指定位置获取迭代器
         */
        System.out.println(myArrayList);
        System.out.println("===================================================");
        ListIterator<String> stringListIterator = myArrayList.listIterator(10);
        for (; stringListIterator.hasPrevious(); ) {
            System.out.println(stringListIterator.previous());
        }
        System.out.println(myArrayList);
    }
}
