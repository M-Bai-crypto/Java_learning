package com.learn.day08.tree.homework;

/**
 *  翻转二叉树
 * @author J.M.Bai
 * @version 1.0
 * @Date 2020/8/19
 */
public class Demo01 {
    public static void main(String[] args) {
        MyTree1<Integer> tree = new MyTree1<>();
        MyTree1.Node reverse = tree.reverse(tree.root);
    }
}


class MyTree1<E> {
    class Node<E> {
        Node left;
        E data;
        Node right;

        Node(E data) {
            this.data = data;
        }
    }

    Node root = null;

    public Node reverse(Node<E> node){
        if (node == null) {
            return null;
        }
        Node temp;
        temp = node.right;
        node.right = node.left;
        node.left = temp;

        node.left = reverse(node.left);
        node.right = reverse(node.right);
        return node;
    }
}
