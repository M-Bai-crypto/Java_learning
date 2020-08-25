package com.learn.day12.blackredtree.homework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;


/**
 * 红黑树
 *
 * @author J.M.Bai
 * @version 1.0
 * @Date 2020/8/25
 */

public class RedBlackTree<K extends Comparable<K>, V> {
    private final static boolean RED = true;
    private final static boolean BLACK = false;
    private TreeNode root;


    /**
     * 结点类
     */
    class TreeNode {
        TreeNode left, right;
        K key;
        V value;
        boolean color;

        TreeNode(K key, V value, boolean color) {
            this.key = key;
            this.value = value;
            this.color = color;
        }
    }

    /**
     * 左旋
     *
     * @param h 被旋转的树
     * @return 返回旋转后的树
     */
    private TreeNode rotateLeft(TreeNode h) {
        TreeNode x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    /**
     * 右旋
     *
     * @param h 被旋转的树
     * @return 返回旋转后的树
     */
    private TreeNode rotateRight(TreeNode h) {
        TreeNode x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    /**
     * 添加元素
     *
     * @param key   需要添加的元素的key
     * @param value 需要添加的元素的value
     */
    public void put(K key, V value) {
        checkKeyIsNull(key);
        root = add(root, key, value);
        root.color = BLACK;
    }


    /**
     * 添加元素
     *
     * @param root  操作的树
     * @param key   添加元素的key
     * @param value 添加元素的value
     * @return 返回添加后的结点
     */
    private TreeNode add(TreeNode root, K key, V value) {
        if (root == null) {
            return new TreeNode(key, value, RED);
        }
        int compare = key.compareTo(root.key);
        if (compare > 0) {
            root.right = add(root.right, key, value);
        } else if (compare < 0) {
            root.left = add(root.left, key, value);
        } else {
            root.value = value;
        }

        // 修复结点
        return fixUp(root);
    }

    /**
     * 对传入的结点进行修复
     *
     * @param root 传入要修复的结点
     * @return 返回修复后的结果
     */
    private TreeNode fixUp(TreeNode root) {
        // 右倾转左倾
        if (isRed(root.right)) {
            root = rotateLeft(root);
        }

        // 连续两条个左红结点右旋
        if (isRed(root.left) && isRed(root.left.left)) {
            root = rotateRight(root);
        }

        // 四节点分裂
        if (isRed(root.left) && isRed(root.right)) {
            colorFlip(root);
        }
        return root;
    }

    /**
     * 四节点分裂
     *
     * @param root 被分裂的树
     */
    private void colorFlip(TreeNode root) {
        root.color = !root.color;
        root.right.color = !root.right.color;
        root.left.color = !root.left.color;
    }

    /**
     * 判断结点是否为红色
     *
     * @param node 需要判断的结点
     * @return 结点为红返回true
     */
    private boolean isRed(TreeNode node) {
        if (node == null) {
            return false;
        }
        return node.color == RED;
    }

    /**
     * 检查传入的元素是否为null
     */
    private void checkKeyIsNull(K key) {
        if (key == null) throw new RuntimeException("key is null");
    }


    /**
     * 层级遍历
     *
     * @return 返回层级遍历结果
     */
    public List<K> levelFind() {
        List<K> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode node = root;
        queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            list.add(poll.key);
            if (poll.left != null)
                queue.offer(poll.left);
            if (poll.right != null)
                queue.offer(poll.right);
        }
        return list;
    }

    /*----------------------------------------------------------------------------*/


    public K floor(K key) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
        if (root == null) throw new NoSuchElementException("Tree is Empty!");
        TreeNode x = floor(root, key);
        if (x == null) return null;
        else return x.key;
    }

    private TreeNode floor(TreeNode x, K key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floor(x.left, key);

        TreeNode t = floor(x.right, key);
        if (t != null) return t;
        return x;
    }

    public K ceiling(K key) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
        if (root == null) throw new NoSuchElementException("Tree is Empty!");
        TreeNode x = ceiling(root, key);
        if (x == null) return null;
        else return x.key;
    }

    private TreeNode ceiling(TreeNode x, K key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp > 0) return ceiling(x.right, key);

        TreeNode t = ceiling(x.left, key);
        if (t != null) return t;
        return x;
    }
}
