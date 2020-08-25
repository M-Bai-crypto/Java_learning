package com.learn.day12.blackredtree.homework;

/**
 * 给定一棵二叉树，判断它是不是镜像对称的。
 *
 * @author J.M.Bai
 * @version 1.0
 * @Date 2020/8/25
 */
public class Demo01 {
    private TreeNode root;

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     *
     * @return 返回该树是否为镜像树
     */
    public boolean isMirror() {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        return (node1.val == node2.val) && (isMirror(node1.left, node2.right)) &&
                (isMirror(node1.right, node2.left));
    }
}
