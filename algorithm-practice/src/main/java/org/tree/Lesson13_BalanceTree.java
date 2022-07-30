package org.tree;

import org.model.TreeNode;

/**
 * 平衡二叉树
 */
public class Lesson13_BalanceTree {
    public static void isBalanceTree() {

    }

    public static Info process(TreeNode treeNode) {
        if (treeNode == null) {
            return new Info(true, 0);
        }

        Info left = process(treeNode.left);
        Info right = process(treeNode.right);

        boolean isBalanced = true;
        if (!left.isBalanced || !right.isBalanced) {
            isBalanced = false;
        }

        if (Math.abs(left.height - right.height) > 1) {
            isBalanced = false;
        }

        int height = Math.max(left.height, right.height) + 1;


        return new Info(isBalanced, height);
    }

    public static class Info {
        public boolean isBalanced;
        public int height;

        public Info(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
}
