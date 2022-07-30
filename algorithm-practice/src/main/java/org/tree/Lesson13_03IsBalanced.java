package org.tree;

import org.model.TreeNode;

/**
 * 平衡二叉树的条件
 * 1.左右两树是平衡二叉树
 * 2.左树高度和右树高度差<=1
 *
 * <p>
 * 判断二叉树是不是平衡二叉树
 * 给定一棵二叉树的头节点head，返回这颗二叉树是不是平衡二叉树
 */
public class Lesson13_03IsBalanced {

    /**
     * 二叉树的递归套路求解
     *
     * @param head
     * @return
     */
    public static Info process(TreeNode head) {
        if (head == null) {
            return new Info(true, 0);
        }
        Info leftInfo = process(head.left);
        Info rightInfo = process(head.right);
        boolean isBalanced = true;
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;

        if (!leftInfo.isBalanced || !rightInfo.isBalanced || Math.abs(leftInfo.height - rightInfo.height) > 1) {
            isBalanced = false;
        }

        return new Info(isBalanced, height);
    }

    private static class Info {
        boolean isBalanced;
        int height;

        public Info(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

}
