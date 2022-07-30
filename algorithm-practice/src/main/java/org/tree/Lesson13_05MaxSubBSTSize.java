package org.tree;

import org.model.TreeNode;

/**
 * 给定一棵二叉树的头节点head，返回这颗二叉树中最大的二叉搜索子树的大小
 * 扩展：返回这颗二叉树中最大的二叉搜索子树的头节点
 * <p>
 * 与X无关
 * 1.左树最大BST的size
 * 2.右树最大BST的size
 * <p>
 * 与X有关
 * 1.左树是BST
 * 2.右树是BST
 * 3.左树的Max<X.val
 * 4.右树树的min>X.val
 * 5.左树的size+右树的size+1
 * <p>
 * <p>
 * https://leetcode.com/problems/largest-bst-subtree
 */
public class Lesson13_05MaxSubBSTSize {

    // 提交如下的largestBSTSubtree方法，可以直接通过
    public static int largestBSTSubtree(TreeNode head) {
        return process(head).maxSubBstSize;
    }

    public static Info process(TreeNode x) {
        if (x == null) {
            return null;
        }

        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

        int allSize = 1;
        int max = x.value;
        int min = x.value;


        if (leftInfo != null) {
            max = Math.max(leftInfo.max, max);
            min = Math.min(leftInfo.min, min);
            allSize += leftInfo.allSize;
        }
        if (rightInfo != null) {
            max = Math.max(rightInfo.max, max);
            min = Math.min(rightInfo.min, min);
            allSize += rightInfo.allSize;
        }


        int p1 = -1;
        if (leftInfo != null) {
            p1 = leftInfo.maxSubBstSize;
        }

        int p2 = -1;
        if (rightInfo != null) {
            p2 = rightInfo.maxSubBstSize;
        }

        int p3 = -1;
        boolean leftBST = leftInfo == null ? true : (leftInfo.allSize == leftInfo.maxSubBstSize);
        boolean rightBST = rightInfo == null ? true : (rightInfo.allSize == rightInfo.maxSubBstSize);
        if (leftBST && rightBST) {
            boolean leftMaxLessX = leftInfo == null ? true : (leftInfo.max < x.value);
            boolean rightMinMoreX = rightInfo == null ? true : (rightInfo.min > x.value);
            if (leftMaxLessX && rightMinMoreX) {
                int leftSize = leftInfo == null ? 0 : (leftInfo.allSize);
                int rightSize = rightInfo == null ? 0 : (rightInfo.allSize);
                p3 = leftSize + rightSize + 1;
            }
        }

        int maxSubBstSize = Math.max(Math.max(p1, p2), p3);
        return new Info(maxSubBstSize, allSize, max, min);
    }

    private static class Info {
        int maxSubBstSize;
        int allSize;
        int max;
        int min;


        public Info(int maxSubBstSize, int allSize, int max, int min) {
            this.maxSubBstSize = maxSubBstSize;
            this.max = max;
            this.min = min;
            this.allSize = allSize;
        }
    }

}
