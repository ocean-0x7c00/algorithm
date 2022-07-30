package org.tree;

import org.model.TreeNode;

/**
 * 给定一棵二叉树的头节点head，和另外两个节点a和b，返回a和b的最低公共祖先
 * 与X无关
 * 1.
 * <p>
 * 与X有关
 * 1.
 */
public class Lesson13_07LowestAncestor {
    public static TreeNode lowestAncestor1(TreeNode head, TreeNode o1, TreeNode o2) {
        if (head == null) {
            return head;
        }

        return process(head, o1, o2).ans;
    }

    public static Info process(TreeNode x, TreeNode a, TreeNode b) {
        if (x == null) {
            return new Info(false, false, null);
        }
        Info leftInfo = process(x.left, a, b);
        Info rightInfo = process(x.right, a, b);

        boolean findA = (x == a) || leftInfo.findA || rightInfo.findA;
        boolean findB = (x == b) || leftInfo.findB || rightInfo.findB;
        TreeNode ans = null;
        if (leftInfo != null) {
            ans = leftInfo.ans;
        } else if (rightInfo != null) {
            ans = rightInfo.ans;
        } else if (findA && findB) {
            ans = x;
        }
        return new Info(findA, findB, ans);
    }


    private static class Info {
        /**
         * 树上是否发现了A
         */
        public boolean findA;
        /**
         * 树上是否发现了B
         */
        public boolean findB;


        public TreeNode ans;

        public Info(boolean findA, boolean findB, TreeNode ans) {
            this.findA = findA;
            this.findB = findB;
            this.ans = ans;
        }
    }
}
