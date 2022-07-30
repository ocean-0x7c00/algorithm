package org.tree;

import org.model.TreeNode;

/**
 * 搜索二叉树
 * 左子树比头节点小
 * 右子树比头节点大
 * <p>
 * 注意：经典的搜索二叉树中没有重复值
 * <p>
 * 方法一
 * 中序遍历一遍，看看是否是升序
 */
public class Lesson13_SearchBinaryTree {
    public static boolean isSearchBinaryTree(TreeNode treeNode) {
        return false;
    }


    public static Info process(TreeNode treeNode) {
        if (treeNode == null) {
            return new Info(true, 0, 0);
        }
        Info left = process(treeNode.left);
        Info right = process(treeNode.right);

        boolean isSearchTree = true;
        if (!left.isBst || !right.isBst) {
            isSearchTree = false;
        }
        if (left.maxLeft >= treeNode.value || right.minRight >= treeNode.value) {
            isSearchTree = false;
        }

        int max = Math.max(left.maxLeft, treeNode.value);
        int min = Math.min(right.minRight, treeNode.value);


        return new Info(isSearchTree, max, min);
    }

    public static class Info {
        public boolean isBst;
        public int maxLeft;
        public int minRight;

        public Info(boolean isBst, int maxLeft, int minRight) {
            this.isBst = isBst;
            this.maxLeft = maxLeft;
            this.minRight = minRight;
        }
    }
}
