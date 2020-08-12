package com.learn.day02.list.homework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * 实现List的嵌套遍历(外层List中的元素是List对象 List<List> list)。
 * @author J.M.Bai
 * @version 1.0
 * @Date 2020/8/12
 */
public class Demo01 {
    public static void main(String[] args) {
        // 内层list
        List<String > innerList1 = new ArrayList<>();
        innerList1.add("1");
        innerList1.add("2");
        innerList1.add("" + "3");

        List<String > innerList2 = new ArrayList<>();
        innerList2.add("a");
        innerList2.add("b");
        innerList2.add("c");

        List<String > innerList3 = new ArrayList<>();
        innerList3.add("inner");
        innerList3.add("list");

        // 外层List
        List<List> outerList = new ArrayList<>();
        outerList.add(innerList1);
        outerList.add(innerList2);
        outerList.add(innerList3);

        // 遍历
        for (int i = 0; i < outerList.size(); i++){
            List next = outerList.get(i);
            for (ListIterator innerIterator = next.listIterator();innerIterator.hasNext();){
                System.out.println(innerIterator.next());
            }
        }
    }
}
