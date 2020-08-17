package com.learn.day06.linkedlist.homework;

import java.util.ListIterator;

/**
 * @author J.M.Bai
 * @version 1.0
 * @Date 2020/8/17
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        linkedList.add("123");
        linkedList.add("456");
        linkedList.add("789");
        linkedList.add("789");

        linkedList.add(0, "a");
        linkedList.add(4, "z");

//        linkedList.clear();

        /*int a = linkedList.indexOf("z");
        System.out.println(a);

        boolean contains = linkedList.contains("456");
        System.out.println(contains);*/

        /*String s = linkedList.get(4);
        System.out.println(s);*/


//        System.out.println(linkedList.size());

        /*boolean remove = linkedList.remove("489");
        System.out.println(remove);*/

        /*String remove1 = linkedList.remove(0);
        System.out.println(remove1);*/

        /*String qiubite = linkedList.set(4, "qiubite");
        System.out.println(qiubite);*/


        /*int a = linkedList.lastIndexOf("789");
        System.out.println(a);

        System.out.println(linkedList);*/

/*------------------------------------------------------------------------------------------------*/
        ListIterator<String> lit = linkedList.listIterator();

        /*for (;lit.hasNext();){
            System.out.println(lit.next());
        }

        ListIterator<String> lit1 = linkedList.listIterator(5);
        lit1.add("10");
        for (;lit1.hasPrevious();){
            System.out.println(lit1.previous());
        }*/


        String next = lit.next();
        lit.set("v");
        System.out.println(linkedList);
        lit.remove();

        System.out.println(linkedList);
    }
}
