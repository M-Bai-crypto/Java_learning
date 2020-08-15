package com.learn.day04.arraylist;

import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * 实现ArrayList部分功能
 *
 * @author J.M.Bai
 * @version 1.0
 * @Date 2020/8/14
 */
public class MyArrayList<E> implements MyList<E> {

    /**
     * 数组实现
     */
    private Object[] elementData;


    /**
     * 元素个数
     */
    private int size;


    /**
     * 修改次数
     */
    private int modCount;

    /**
     * 最大数组大小
     */
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    /**
     * 无参构造，默认创建10个大小的集合
     */
    public MyArrayList() {
        elementData = new Object[10];
    }

    /**
     * 创建指定容量集合
     *
     * @param capacity 自定义容量
     */

    public MyArrayList(int capacity) {
        if (capacity > 0 && capacity < MAX_ARRAY_SIZE) {
            elementData = new Object[capacity];
        } else {
            throw new IllegalArgumentException("参数非法：capacity=" + capacity);
        }
    }

    /**
     * 将指定元素插入到集合末尾
     *
     * @param e 插入的元素
     * @return 插入成功返回true，有异常抛出
     */
    @Override
    public boolean add(E e) {
        add(size, e);
        return true;
    }

    /**
     * 将指定元素插入到指定位置
     *
     * @param index   指定位置
     * @param element 指定元素
     */
    @Override
    public void add(int index, E element) {
        // 判断参数是否非法
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index=" + index);
        }

        // 保证容量
        int minCapacity = size + 1;
        if (minCapacity > elementData.length) {
            // 计算扩容容量
            int newCapacity = grow(minCapacity);

            // 复制到新数组
            arrayCopy(newCapacity);
        }

        // 给新增元素腾位置
        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }

        // 增加元素
        elementData[index] = element;
        // 收尾工作
        modCount++;
        size++;
    }

    /**
     * 对数组进行复制
     *
     * @param newCapacity 新的数组长度
     */
    private void arrayCopy(int newCapacity) {
        Object[] targetArray = new Object[newCapacity];
        // 对原有数据进行复制
        for (int i = 0; i < size; i++) {
            targetArray[i] = elementData[i];
        }
        elementData = targetArray;
    }

    /**
     * 扩容操作
     *
     * @param minCapacity 最小要求
     * @return 返回计算后的新长度
     */
    private int grow(int minCapacity) {
        // 默认扩容1.5倍
        int newCapacity = elementData.length + (elementData.length >> 1);

        // 最小要求超过了极限,返回最大长度
        if (newCapacity < 0 || newCapacity > MAX_ARRAY_SIZE) {
            return MAX_ARRAY_SIZE;
        }

        // 防止其它方法调用，返回最小要求和扩容容量的最大值
        return newCapacity < minCapacity ? minCapacity : newCapacity;
    }

    /**
     * 清空集合
     */
    @Override
    public void clear() {
        modCount++;
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    /**
     * 移除指定位置元素
     *
     * @param index 指定位置
     * @return 返回移除前的元素
     */
    @Override
    public E remove(int index) {
        checkIndex(index);

        E removeElement = (E) elementData[index];
        // 所有索引以后元素向前移动
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }

        // 最后一位置空
        elementData[size - 1] = null;

        // 收尾工作
        modCount++;
        size--;

        return removeElement;
    }

    /**
     * 检查index参数是否合法
     *
     * @param index 传入的索引参数
     */
    private void checkIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("index=" + index);
        }
    }

    /**
     * 如果此列表包含指定的元素，则返回 true
     *
     * @param o 指定元素
     * @return 返回移除是否成功
     */
    @Override
    public boolean remove(Object o) {
        // 找到第一次出现的位置
        int removeIndex = indexOf(o);
        if (removeIndex != -1) {
            // 调用指定索引的删除方法
            remove(removeIndex);
            return true;
        }
        return false;
    }

    /**
     * 将指定位置的参数设置为指定值
     *
     * @param index   指定位置
     * @param element 指定元素
     * @return 返回设置前的元素
     */
    @Override
    public E set(int index, E element) {
        checkIndex(index);
        E setElement = (E) elementData[index];
        elementData[index] = element;
        return setElement;
    }

    /**
     * 返回是否包含指定元素
     *
     * @param o 指定元素
     * @return 如果此列表中包含指定的元素，则返回 true。否则返回false
     */
    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    /**
     * 返回指定位置的元素
     *
     * @param index 指定位置
     * @return 返回元素
     */
    @Override
    public E get(int index) {
        checkIndex(index);
        E getElement = (E) elementData[index];
        return getElement;
    }

    /**
     * 返回指定元素第一次出现的位置
     *
     * @param o 指定元素，包括null
     * @return 返回出现位置，没有查找到返回-1
     */
    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elementData[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 返回指定元素在集合中最后一次出现的位置
     *
     * @param o 指定元素
     * @return 返回位置，没有找到返回-1
     */
    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (o.equals(elementData[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 返回该集合是否为空
     *
     * @return 如果为空返回true，否则返回false
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @return 返回集合元素个数
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * @return 返回此列表元素的列表迭代器
     */
    @Override
    public ListIterator listIterator() {
        return new ListItr();
    }

    /**
     * 返回列表中元素的列表迭代器（按适当顺序），从列表的指定位置开始。
     *
     * @param index 指定位置
     * @return 返回从指定位置开始的迭代器
     */
    @Override
    public ListIterator<E> listIterator(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index=" + index);
        }
        return new ListItr(index);
    }

    private class ListItr implements ListIterator<E> {
        /**
         * 游标位置默认为0
         */
        private int cursor;

        /**
         * 游标移动时经过的元素对应索引，默认没有(设为-1)
         */
        private int lastRet = -1;

        /**
         * 期望修改次数，默认为迭代前修改次数
         * 在remove和set时进行判断
         */
        private int expectModCount = modCount;

        /**
         * 无参构造
         */
        ListItr() {
        }

        /**
         * 返回列表中元素的列表迭代器，从列表的指定位置开始。
         *
         * @param index 指定开始位置
         */
        ListItr(int index) {
            if (index < 0 || index > size) {
                throw new IllegalArgumentException();
            }
            this.cursor = index;
        }

        /**
         * @return 返回是否有下一个元素
         */
        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        /**
         * @return 返回列表中的下一个元素, 没有抛出异常
         */
        @Override
        public E next() {
            // 判断集合是否发生结构性变化
            checkConCurrentModification();
            // 如果有下一个
            if (hasNext()) {
                // 记录当前位置lastRet
                lastRet = cursor;

                // 游标向后移动一位
                cursor++;

                // 返回迭代经过的元素
                return (E) elementData[lastRet];
            }
            // 没有抛出异常
            throw new NoSuchElementException();
        }

        @Override
        public boolean hasPrevious() {
            return cursor > 0;
        }

        @Override
        public E previous() {
            // 判读集合是否发生变化
            checkConCurrentModification();
            // 如果有前一个
            if (hasPrevious()) {
                // 游标向前移动一位
                // 记录移动经过的元素
                lastRet = --cursor;

                // 返回元素
                return (E) elementData[lastRet];
            }
            // 没有抛出异常
            throw new NoSuchElementException();
        }

        /**
         * @return 返回对 next 的后续调用所返回元素的索引。
         */
        @Override
        public int nextIndex() {
            return cursor;
        }

        /**
         * @return 返回对 previous 的后续调用所返回元素的索引。
         */
        @Override
        public int previousIndex() {
            return cursor - 1;
        }

        /**
         * 从列表中移除由 next 或 previous 返回的最后一个元素
         */
        @Override
        public void remove() {
            checkConCurrentModification();
            // 如果集合被迭代器破环结构，抛出异常
            if (lastRet == -1) {
                throw new IllegalStateException();
            }
            MyArrayList.this.remove(lastRet);

            cursor = lastRet;
            expectModCount = modCount;
            lastRet = -1;
        }

        /**
         * 用指定元素替换 next 或 previous 返回的最后一个元素
         *
         * @param o 指定要更改为哪个元素
         */
        @Override
        public void set(E o) {
            checkConCurrentModification();
            if (lastRet == -1) {
                throw new IllegalStateException();
            }

            MyArrayList.this.set(lastRet, o);
        }

        @Override
        public void add(E o) {
            checkConCurrentModification();
            MyArrayList.this.add(cursor, o);
            cursor++;
            expectModCount = modCount;
            lastRet = -1;
        }

        /**
         * 检查期望修改次数和实际修改次数是否一致
         * 即 判断 是否有迭代器以外的操作修改了该集合
         *
         * @throws ConcurrentModificationException;
         */
        private void checkConCurrentModification() {
            if (modCount != expectModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }

    /**
     * @return 集合的遍历返回字符串形式
     */
    @Override
    public String toString() {
        StringBuilder resultString = new StringBuilder();
        resultString.append("[");
        if (size > 0) {
            resultString.append(elementData[0]);
            for (int i = 1; i < size; i++) {
                resultString.append("," + elementData[i]);
            }
        }
        resultString.append("]");
        return resultString.toString();
    }
}
