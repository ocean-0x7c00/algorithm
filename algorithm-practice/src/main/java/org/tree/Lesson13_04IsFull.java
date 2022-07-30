package org.tree;

import org.model.TreeNode;

/**
 * 满二叉树
 * 节点数=2^h - 1
 * 判断二叉树是不是满二叉树
 */
public class Lesson13_04IsFull {


    public static boolean isFull1(TreeNode head) {
        if (head == null) {
            return true;
        }
        Info info = process(head);

        return (1 << info.height) == info.nodes;
    }

    public static Info process(TreeNode head) {
        if (head == null) {
            return new Info(0, 0);
        }
        Info leftInfo = process(head.left);
        Info rightInfo = process(head.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int nodeNum = leftInfo.nodes + rightInfo.nodes + 1;

        return new Info(height, nodeNum);

    }

    private static class Info {
        public int height;
        public int nodes;

        public Info(int height, int nodes) {
            this.height = height;
            this.nodes = nodes;
        }
    }

}
