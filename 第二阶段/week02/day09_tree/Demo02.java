package com.learn.day08.tree.homework;

import java.util.ArrayList;
import java.util.List;

/**
 * 根据中序和后续遍历实现建树操作
 *
 * @author J.M.Bai
 * @version 1.0
 * @Date 2020/8/20
 */
public class Demo02 {
    public static void main(String[] args) {
        ArrayList<Character> inorderList = new ArrayList<>();
        String inorderStr = "DBEAFCG";
        for (int i = 0; i < inorderStr.length(); i++) {
            inorderList.add(inorderStr.charAt(i));
        }
        ArrayList<Character> postOrderList = new ArrayList<>();
        String postStr = "DEBFGCA";
        for (int i = 0; i < postStr.length(); i++) {
            postOrderList.add(postStr.charAt(i));
        }
        MyTree<Character> tree = new MyTree<>();
        MyTree<Character> newTree = tree.build(inorderList, postOrderList);
    }
}


class MyTree<E> {
    class Node {
        Node left;
        E data;
        Node right;

        Node(E data) {
            this.data = data;
        }
    }

    private Node root = null;

    /**
     * 返回建立的树
     *
     * @return 返回树
     */
    public MyTree<E> build(List<E> inOrder, List<E> postOrder) {
        MyTree<E> tree = new MyTree<>();
        tree.root = treeBuild(inOrder, postOrder);
        return tree;
    }

    /**
     * 根据中序和后序遍历实现建树操作
     *
     * @param inOrder   中序遍历
     * @param postOrder 后序遍历
     * @return 返回树的根结点
     */
    private Node treeBuild(List<E> inOrder, List<E> postOrder) {
        if (postOrder.size() == 0) {
            return null;
        }
        // 通过后序找到根
        E root = postOrder.get(postOrder.size() - 1);
        Node node = new Node(root);

        // 中序根据根进行截取创建左右子树
        int index = inOrder.indexOf(root);
        List<E> leftInorder = inOrder.subList(0, index);
        List<E> rightInorder = inOrder.subList(index + 1, inOrder.size());
        List<E> leftPostOrder = postOrder.subList(0, index);
        List<E> rightPostOrder = postOrder.subList(index, postOrder.size() - 1);
        Node leftNode = treeBuild(leftInorder, leftPostOrder);
        Node rightNode = treeBuild(rightInorder, rightPostOrder);

        // 对截取结果进行建树指向根结点并返回
        node.left = leftNode;
        node.right = rightNode;
        return node;
    }
}
