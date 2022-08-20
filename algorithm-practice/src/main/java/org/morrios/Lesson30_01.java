package org.morrios;

import org.model.TreeNode;

public class Lesson30_01 {

    public static void morris(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode cur = head;
        TreeNode mostRight = head;
        while (cur != null) {
            mostRight = cur.left;

            //有左孩子
            if (mostRight != null) {

                //一路往右走，并且不能等于cur(等于cur有环)
                while (mostRight.right != null && mostRight != cur) {
                    mostRight = mostRight.right;
                }

                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }


            }


            //无左孩子
            cur = cur.right;
        }
    }


    /**
     * 先序遍历
     *
     * @param head
     */
    public static void morrisPre(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode cur = head;
        TreeNode mostRight = head;
        while (cur != null) {
            mostRight = cur.left;

            //有左孩子
            if (mostRight != null) {

                //一路往右走，并且不能等于cur(等于cur有环)
                while (mostRight.right != null && mostRight != cur) {
                    mostRight = mostRight.right;
                }

                if (mostRight.right == null) {
                    System.out.println(cur.value);
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }


            } else {
                System.out.println(cur.value);
            }


            //无左孩子
            cur = cur.right;
        }
    }

    /**
     * 中序遍历
     *
     * @param head
     */
    public static void morrisIn(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode cur = head;
        TreeNode mostRight = head;
        while (cur != null) {
            mostRight = cur.left;

            //有左孩子
            if (mostRight != null) {

                //一路往右走，并且不能等于cur(等于cur有环)
                while (mostRight.right != null && mostRight != cur) {
                    mostRight = mostRight.right;
                }

                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }


            }
            System.out.println(cur.value);
            //无左孩子
            cur = cur.right;
        }
    }


    /**
     * 后序遍历
     *
     * @param head
     */
    public static void morrisPost(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode cur = head;
        TreeNode mostRight = null;
        while (cur != null) {

            mostRight = cur.left;

            //有左孩子
            if (mostRight != null) {

                //一路往右走，并且不能等于cur(等于cur有环)
                while (mostRight.right != null && mostRight != cur) {
                    mostRight = mostRight.right;
                }

                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                    //后序遍历，逆序打印左树的有边界
                    printEdge(cur.left);
                }

            }
            //无左孩子
            cur = cur.right;
        }


        //最后打印整棵树的右边界
        printEdge(head);

    }


    /**
     * 逆序打印树的边界
     *
     * @param node
     */
    public static void printEdge(TreeNode node) {

    }


    /**
     * 怎么判断一棵树是搜索二叉树
     * 中序遍历的结果是升序
     * <p>
     * 通常做法中序遍历后，再遍历一遍
     * <p>
     * 怎么判断一个数组是升序
     */
    public static void method() {

    }

    /**
     * 如何记录层数
     * <p>
     * <p>
     * <p>
     * 如何发现叶节点
     * 第二次回到节点，判断是不是叶节点；最后单独检查整棵树的最有节点
     */
    public static void method2() {

    }

}
