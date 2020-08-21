package com.learn.day09.map.homework;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 给定一棵二叉搜索树，它的根结点为root。
 * 求这棵树中不同结点的最小差值。
 *
 * @author J.M.Bai
 * @version 1.0
 * @Date 2020/8/21
 */
public class Demo02 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public int minDiffInBST(TreeNode root) {
            ArrayList<TreeNode> nodes = new ArrayList<>();
            TreeSet<Integer> value = new TreeSet<>();
            preOrder(root, nodes); // 获取先序遍历结果
            int min;

            // 遍历确保对每一个结点都进行了同样的操作
            for (TreeNode node : nodes) {
                // 对一个结点，找其右子树中的最小值和它做减法，数据存入treeSet
                if (node.right != null) {
                    min = node.val - minRight(node.right).val;
                    value.add(min);
                }
                if (node.left != null) {
                    // 同一个结点，找其左子树中的最大值和它做减法，数据存入treeSet
                    min = node.val - maxLeft(node.left).val;
                    value.add(min);
                }
            }

            // 输出treeSet中和0最相近的值
            Integer ceiling = value.ceiling(0);
            Integer floor = value.floor(0);
            return ceiling > floor ? Math.abs(floor) : ceiling;
        }


        // 返回左子树中的最大值
        private TreeNode maxLeft(TreeNode root) {
            while (root.right != null) {
                root = root.right;
            }
            return root;
        }

        // 返回右子树的最小值
        private TreeNode minRight(TreeNode root) {
            while (root.left != null) {
                root = root.left;
            }
            return root;
        }

        public void preOrder(TreeNode root, ArrayList<TreeNode> list) {
            if (root == null) {
                return;
            }
            list.add(root);
            preOrder(root.left, list);
            preOrder(root.right, list);
        }
    }
}


