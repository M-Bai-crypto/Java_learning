package com.learn.day06.linkedlist.homework;

import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * @author J.M.Bai
 * @version 1.0
 * @Date 2020/8/17
 */
public class MyLinkedList<E> implements MyList<E> {
    // 成员变量
    private int size;
    private int modCount;
    private Node head;
    private Node tail;

    /**
     * 定义节点
     */
    private class Node {
        Node pre;
        E data;
        Node next;

        public Node(E data) {
            this.data = data;
        }

        public Node(Node pre, E data, Node next) {
            this.pre = pre;
            this.data = data;
            this.next = next;
        }
    }

    /**
     * 无参构造
     */
    public MyLinkedList() {
        head = new Node(null, null, null);
        tail = new Node(null, null, null);

        head.next = tail;
        tail.pre = head;
    }

    /**
     * 在此列表中指定的位置插入指定的元素。
     *
     * @param e 传入指定元素
     * @return 插入成功返回true
     */
    @Override
    public boolean add(E e) {
        add(size, e);
        return true;
    }

    /**
     * 在指定位置增加指定元素
     *
     * @param index   指定插入位置
     * @param element 插入指定元素
     * @throws IllegalArgumentException index = [0,size]
     */
    @Override
    public void add(int index, E element) {
        checkIndexForSize(index);

        // 创建需要插入的节点对象
        Node newNode;

        // 被插入的节点
        Node node;

        // 判断是插入末尾还是插入中间
        if (index == size) {
            // 元素插入到集合末尾
            node = tail;
            newNode = new Node(node.pre, element, node);
        } else {
            // 元素插入到集合中间
            node = getNode(index);
            newNode = new Node(node.pre, element, node);
        }

        // 修改节点之间的关系
        node.pre.next = newNode;
        node.pre = newNode;

        size++;
        modCount++;
    }

    /**
     * 返回对应索引的节点
     *
     * @param index 对应的索引
     * @return 返回对应的节点
     */
    private Node getNode(int index) {
        checkIndexOutOfBounds(index);

        // 遍历集合，返回节点
        Node node = null;

        if (!isEmpty()) {
            node = head.next;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        }

        // 集合为空时返回null
        return node;
    }

    /**
     * 检查添加元素时的索引是否合法
     *
     * @param index 添加元素时的索引
     * @throws IllegalArgumentException index = [0,size)
     */
    private void checkIndexForSize(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index = " + index);
        }
    }

    /**
     * 清空集合
     */
    @Override
    public void clear() {
        head.next = tail;
        tail.pre = head;
        size = 0;
        modCount++;
    }

    /**
     * 移除集合中指定位置的元素
     *
     * @param index 指定位置
     * @return 返回移除前的元素
     */
    @Override
    public E remove(int index) {
        checkIndexOutOfBounds(index);

        // 修改对应关系
        Node node = getNode(index);
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.pre = null;
        node.next = null;

        size--;
        modCount++;
        return node.data;

    }

    /**
     * 如果索引越界，抛出异常
     *
     * @param index 指定要查询的索引
     * @throws IndexOutOfBoundsException 索引越界，抛出异常
     */
    private void checkIndexOutOfBounds(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("index = " + index + ", size = " + size);
        }
    }

    /**
     * 移除指定首次出现的元素
     *
     * @param o 指定元素
     * @return 返回移除是否成功
     */
    @Override
    public boolean remove(Object o) {
        // 找到索引元素对应的索引
        int index = indexOf(o);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    /**
     * 将此列表中指定位置的元素替换为指定的元素。
     *
     * @param index   指定修改位置
     * @param element 指定修改元素
     * @return 返回修改之前的元素
     */
    @Override
    public E set(int index, E element) {
        checkIndexOutOfBounds(index);
        Node node = getNode(index);
        E dataBefore = node.data;
        node.data = element;
        return dataBefore;
    }

    /**
     * 判断集合中是否包含指定元素
     *
     * @param o 传入指定元素
     * @return 如果包含返回true，否则返回false
     */
    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    /**
     * 返回指定索引对应的元素
     *
     * @param index 指定索引
     * @return 返回索引对应的元素
     */
    @Override
    public E get(int index) {
        checkIndexOutOfBounds(index);
        Node node = getNode(index);
        return node.data;
    }

    /**
     * 返回指定元素在集合中第一次出现的位置
     *
     * @param o 指定元素
     * @return 返回元素第一次出现的位置
     */
    @Override
    public int indexOf(Object o) {
        Node node = head.next;
        // 记录找到指定元素的位置
        int index = 0;

        if (o == null) {
            while (index < size) {
                if (null == node.data) {
                    return index;
                }
                node = node.next;
                index++;
            }
        } else {
            while (index < size) {
                if (o.equals(node.data)) {
                    return index;
                }
                node = node.next;
                index++;
            }
        }
        // 没有找到返回-1
        return -1;
    }

    /**
     * 返回指定元素在集合中最后一次出现的位置
     *
     * @param o 指定元素
     * @return 返回元素最后一次出现的位置
     */
    @Override
    public int lastIndexOf(Object o) {
        Node node = tail.pre;
        // 记录找到指定元素的位置(逆向查找)
        int index = 1;

        if (o == null) {
            while (node != head) {
                if (null == node.data) {
                    return size - index;
                }
                node = node.pre;
                index++;
            }
        } else {
            while (node != head) {
                if (o.equals(node.data)) {
                    return size - index;
                }
                node = node.pre;
                index++;
            }
        }
        // 没有找到返回-1
        return -1;
    }

    /**
     * 返回该集合是否为空
     *
     * @return 集合为空时返回true，不为空返回false
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 返回集合的实际元素个数
     *
     * @return 返回集合实际元素个数
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * 返回listIterator迭代器
     *
     * @return 返回迭代器
     */
    @Override
    public ListIterator<E> listIterator() {
        return new ListItr();
    }

    /**
     * 返回从index开始的，listIterator迭代器
     *
     * @param index 指定迭代器开始位置
     * @return 返回迭代器
     */
    @Override
    public ListIterator<E> listIterator(int index) {
        checkIndexForSize(index);
        return new ListItr(index);
    }

    private class ListItr implements ListIterator<E> {
        // 定义成员变量
        int cursor;
        int expectedModCount = MyLinkedList.this.modCount;
        Node currentNode; // 当前节点，cursor的值对应索引的节点
        Node lastRtn = null;

        /**
         * 创建无参迭代器
         */
        ListItr() {
            currentNode = head.next;
        }

        /**
         * 创建从指定索引开始的迭代器
         *
         * @param index 指定迭代器开始的索引位置
         */
        ListItr(int index) {
            cursor = index;
            if (index == size) {
                currentNode = tail;
            } else {
                currentNode = getNode(index);
            }
        }

        /**
         * 返回是否还有下一个元素
         *
         * @return 返回是否还有下一个元素
         */
        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        /**
         * cursor向后移动一位，记录移动经过的元素
         *
         * @return 返回列表中的下一个元素。
         * @throws NoSuchElementException 如果没有可迭代的下一个元素。
         */
        @Override
        public E next() {
            checkConCurrentModification();

            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            // 记录当前元素
            lastRtn = currentNode;

            // 向后移动
            currentNode = currentNode.next;

            cursor++;
            return lastRtn.data;
        }

        /**
         * 返回是否还有上一个元素
         *
         * @return 返回是否还有上一个元素
         */
        @Override
        public boolean hasPrevious() {
            return cursor > 0;
        }

        /**
         * 返回列表中的前一个元素。
         *
         * @return 返回列表中的前一个元素。
         * @throws NoSuchElementException 如果没有可迭代的上一个元素。
         */
        @Override
        public E previous() {
            checkConCurrentModification();

            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }

            // 向前移动
            currentNode = currentNode.pre;

            // 记录当前元素
            lastRtn = currentNode;

            cursor--;
            return lastRtn.data;
        }

        /**
         * 返回对 next 的后续调用所返回元素的索引。
         *
         * @return 返回对 next 的后续调用所返回元素的索引。
         */
        @Override
        public int nextIndex() {
            return cursor;
        }

        /**
         * 返回对 previous 的后续调用所返回元素的索引。
         *
         * @return 返回对 previous 的后续调用所返回元素的索引。
         */
        @Override
        public int previousIndex() {
            return cursor - 1;
        }

        /**
         * 从列表中移除由 next 或 previous 返回的最后一个元素
         *
         * @throws IllegalStateException 最后一个元素位置丢失
         */
        @Override
        public void remove() {
            checkConCurrentModification();
            if (lastRtn == null) {
                throw new IllegalStateException();
            }

            // 保存lastRen的下一个节点
            Node next = lastRtn.next;

            // 修改对应关系
            lastRtn.pre.next = lastRtn.next;
            lastRtn.next.pre = lastRtn.pre;
            lastRtn.pre = null;
            lastRtn.next = null;

            // 如果删除的是prev返回的元素,cursor不动，对象指向被删除的下一个
            if (lastRtn == currentNode) {
                currentNode = next;
            } else {
                // 删除的是next返回的元素
                cursor--;
            }
            lastRtn = null;
        }

        /**
         * 修改由 next 或 previous 返回的最后一个元素为指定元素
         *
         * @param e 指定元素
         */
        @Override
        public void set(E e) {
            checkConCurrentModification();
            if (lastRtn == null) {
                throw new IllegalStateException();
            }

            lastRtn.data = e;
        }

        /**
         * 在cursor的位置上增加指定元素
         *
         * @param e 指定增加元素
         */
        @Override
        public void add(E e) {
            checkConCurrentModification();
            MyLinkedList.this.add(cursor, e);

            cursor++;
            expectedModCount = modCount;
            lastRtn = null;
        }

        /**
         * 判断并发修改异常
         */
        private void checkConCurrentModification() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }


    /**
     * 返回集合的字符串表达形式
     *
     * @return 返回字符串
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");

        // 至少存在一个元素
        if (!isEmpty()) {
            Node node = head.next;
            while (node != tail) {
                result.append(node.data + ",");
                node = node.next;
            }
            result.delete(result.length() - 1, result.length());
        }

        result.append("]");
        return result.toString();
    }
}
