package org.tree;

import org.model.TreeNode;

/**
 * 搜索二叉树的定义（经典的搜索二叉树中没有重复值）
 * 1.左树的最大值小于头节点
 * 2.右树的最小值大于头节点
 * <p>
 * 判断二叉树是不是搜索二叉树
 * <p>
 * <p>
 * 方法1：中序遍历，升序
 * 方法2：递归
 */
public class Lesson13_02IsBST {

    public static boolean isBST(TreeNode head) {
        if (head == null) {
            return true;
        }
        return process(head).isBST;
    }


    public static Info process(TreeNode x) {
        if (x == null) {
            return null;
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);


        int max = x.value;
        if (leftInfo != null) {
            max = Math.max(leftInfo.max, max);
        }
        if (rightInfo != null) {
            max = Math.max(rightInfo.max, max);
        }

        int min = x.value;
        if (leftInfo != null) {
            min = Math.min(leftInfo.min, min);
        }
        if (rightInfo != null) {
            min = Math.min(rightInfo.min, min);
        }


        boolean isBST = true;
        if (leftInfo != null && !leftInfo.isBST) {
            isBST = false;
        }
        if (rightInfo != null && !rightInfo.isBST) {
            isBST = false;
        }

        if ((leftInfo != null && !leftInfo.isBST) || (rightInfo != null && !rightInfo.isBST)) {
            isBST = false;
        }


        if ((leftInfo != null && leftInfo.max >= x.value) || (rightInfo != null && rightInfo.min <= x.value)) {
            isBST = false;
        }

        return new Info(isBST, max, min);
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(4);
        head.left = left;
        head.right = right;
        head.right.left = new TreeNode(3);
        head.right.right = new TreeNode(6);
        boolean bst = process(head).isBST;

        System.out.println(bst);
//        [5,1,4,null,null,3,6]
        System.out.println();
    }

    private static class Info {
        boolean isBST;
        int max;
        int min;

        public Info(boolean isBST, int max, int min) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
        }
    }

}
