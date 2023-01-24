package leetcode;

import leetcode.model.TreeNode;

/**
 * 二叉树中的最大路径和
 * 任一一个节点到任一一个节点
 * <p>
 * 二叉树的递归套路
 */
public class Problem66_Code124 {
    public  int maxPathSum(TreeNode root) {
        return process(root).totalSum;
    }

    public Info process(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }


        Info leftInfo = process(treeNode.left);
        Info rightInfo = process(treeNode.right);


        Info info = new Info();
        int p1 = -1;
        if (leftInfo != null) {
            p1 = Math.max(p1, leftInfo.leftHeight);
        }
        if (rightInfo != null) {
            p1 = Math.max(p1, rightInfo.rightHeight);
        }


        return info;

    }

    public class Info {

        int totalSum;
        int maxLeftSum;
        int maxRightSum;
        int leftHeight;
        int rightHeight;

        public Info() {
        }

        public Info(int maxLeftSum, int maxRightSum, int leftHeight, int rightHeight) {
            this.maxLeftSum = maxLeftSum;
            this.maxRightSum = maxRightSum;
            this.leftHeight = leftHeight;
            this.rightHeight = rightHeight;
        }
    }
}
