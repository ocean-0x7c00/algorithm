package classic;


import model.TreeNode;

/**
 * 给定一个二叉树的头节点head，路径的规定有以下三种不同的规定：
 * 1）路径必须是头节点出发，到叶节点为止，返回最大路径和
 * 2）路径可以从任何节点出发，但必须往下走到达任何节点，返回最大路径和
 * 3）路径可以从任何节点出发，到任何节点，返回最大路径和
 */
public class Problem_007_MaxSumInTree {
    /**
     * 路径必须是头节点出发，到叶节点为止，返回最大路径和
     */
    public static class case1 {


        static int maxDistance = Integer.MIN_VALUE;

        public static int method1(TreeNode head) {
            process1(head, 0);
            return maxDistance;
        }

        public static void process1(TreeNode head, int pre) {
            if (head.left == null && head.right == null) {
                maxDistance = Math.max(maxDistance, head.value + pre);
            }

            if (head.left != null) {
                process1(head.left, pre + head.value);
            }

            if (head.right != null) {
                process1(head.right, pre + head.value);
            }


        }


    }

    /**
     * 路径可以从任何节点出发，但必须往下走到达任何节点，返回最大路径和
     */
    public static class case2 {
    }

    /**
     * 路径可以从任何节点出发，到任何节点，返回最大路径和
     */
    public static class case3 {
    }
}
