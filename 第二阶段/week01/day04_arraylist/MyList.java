package com.learn.day04.arraylist;

import java.util.ListIterator;

/**
 * 定义要在自定义ArrayList中实现的接口
 *
 * @author J.M.Bai
 * @version 1.0
 * @Date 2020/8/14
 */
public interface MyList<E> {
    /**
     * 增加
     *
     * @param e
     * @return
     */
    boolean add(E e);

    void add(int index, E element);


    /**
     * 删除
     */
    void clear();

    E remove(int index);

    boolean remove(Object o);


    /**
     * 修改
     *
     * @param index
     * @param element
     * @return
     */
    E set(int index, E element);


    /**
     * 查询
     *
     * @param o
     * @return
     */

    boolean contains(Object o);

    E get(int index);

    int indexOf(Object o);

    int lastIndexOf(Object o);

    boolean isEmpty();

    int size();


    /**
     * @return 迭代器
     */
    ListIterator<E> listIterator();

    ListIterator<E> listIterator(int index);

}
