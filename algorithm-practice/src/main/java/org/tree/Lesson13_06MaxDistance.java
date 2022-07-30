package org.tree;

import org.model.TreeNode;

/**
 * 距离：沿途的节点数量
 * 给定一棵二叉树的头节点head，任何两个节点之间都存在距离，返回整棵二叉树的最大距离
 * <p>
 * 1.x左树上的最大距离
 * 2.x右树上的最大距离
 * 3.经过x，左树离x最远的节点（左树的高度）+右树离x最远的节点（右树高度）+1
 */
public class Lesson13_06MaxDistance {

    public static int maxDistance1(TreeNode head) {
        return process(head).maxDistance;
    }

    public static Info process(TreeNode x) {
        if (x == null) {
            return new Info(0, 0);
        }

        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;

        int maxDistance = Math.max(leftInfo.maxDistance, rightInfo.maxDistance);
        maxDistance = Math.max(leftInfo.height + rightInfo.height + 1, maxDistance);


        return new Info(maxDistance, height + 1);
    }

    private static class Info {
        /**
         * 整棵树的最大距离
         */
        int maxDistance;

        /**
         * 整棵树的高度
         */
        int height;

        public Info(int maxDistance, int height) {
            this.maxDistance = maxDistance;
            this.height = height;
        }
    }


}
