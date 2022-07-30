package org.tree;

import org.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断二叉树是不是完全二叉树
 * <p>
 * 1.每一层是满的
 * 2.如果不满，从左到右依次变满
 * <p>
 * <p>
 * 解法
 * 1.二叉树的按层遍历
 */
public class Lesson13_01IsCBT {

    /**
     * 二叉树的按层遍历
     *
     * @param head
     * @return
     */
    public static boolean isCBT1(TreeNode head) {
        if (head == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);

        //是否遇到过不双全的节点
        boolean isLeaf = false;
        TreeNode leftChild = null;
        TreeNode rightChild = null;
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            leftChild = treeNode.left;
            rightChild = treeNode.right;

            //如果已经是叶子节点了，又发现还有左孩子或右孩子，则表示从左到右没有一次变满
            if ((isLeaf && (leftChild != null || rightChild != null)) || (leftChild == null && rightChild != null)) {
                return false;
            }

            if (leftChild != null) {
                queue.add(leftChild);
            }
            if (rightChild != null) {
                queue.add(rightChild);
            }


            //左孩子或右孩子，只要有一个为null，就表示来到的树的叶子节点
            if (leftChild == null || rightChild == null) {
                isLeaf = true;
            }


        }
        return true;
    }

    /**
     * 使用二叉树的递归套路实现
     * <p>
     * 1.左树是满的，右树是满的，左高等于右高
     * 2.左树是CBT，右树是CBT，左高等于右高+1
     * 3.左树是满二叉树，右树是CBT，左高等于右高+1
     * 4.左满等于右满，左高等于右高
     *
     * @param head
     * @return
     */
    public static boolean isCBT2(TreeNode head) {
        return false;
    }


    public static Info process(TreeNode head) {
        if (head == null) {
            return new Info(true, true, 0);
        }

        Info leftInfo = process(head.left);
        Info rightInfo = process(head.right);

        int height = Math.max(leftInfo.height, rightInfo.height);
        boolean isFull = leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height;

        boolean isCBT = false;

        if (leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height) {
            isCBT = true;
        } else if (leftInfo.isCBT && rightInfo.isFull && leftInfo.height == rightInfo.height + 1) {
            isCBT = true;
        } else if (leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height + 1) {
            isCBT = true;
        } else if (leftInfo.isFull && rightInfo.isCBT && leftInfo.height == rightInfo.height) {
            isCBT = true;
        }
        return new Info(isFull, isCBT, height);
    }

    private static class Info {
        public boolean isFull;
        public boolean isCBT;
        public int height;

        public Info(boolean isFull, boolean isCBT, int height) {
            this.isFull = isFull;
            this.isCBT = isCBT;
            this.height = height;
        }
    }
}
