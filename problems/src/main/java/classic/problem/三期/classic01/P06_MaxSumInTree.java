package classic.problem.三期.classic01;

import model.TreeNode;

/**
 * 二叉树最大路径和问题
 */
public class P06_MaxSumInTree {
    public static void main(String[] args) {
    }

    /**
     * 路径必须是头节点出发，到叶节点为止，返回最大路径和
     */
    public static class MaxSumInTree1 {
        static int max = 0;

        public static int maxDistance(TreeNode head) {
            process(head, 0);
            return max;
        }

        /**
         * 之前路径上的节点累加和
         *
         * @param node
         * @param pre
         */
        public static void process(TreeNode node, int pre) {
            if (node.left == null && node.right == null) {
                Math.max(max, node.value + pre);
            }
            if (node.left != null) {
                process(node.left, pre + node.value);
            }
            if (node.right != null) {
                process(node.right, pre + node.value);
            }
        }
    }

    /**
     * 路径可以从任何节点出发，但必须往下走到达任何节点，返回最大路径和
     */
    public static class MaxSumInTree2 {
        public static int maxDistance(TreeNode head) {

            if (head == null) {
                return 0;
            }
            return process(head).allMax;
        }

        /**
         * 之前路径上的节点累加和
         * a.X 无关 1.左树有最大路径 2.右树有最大路径
         * b.X 有关 3.X自身就是最大路径 4.X向左走出最大路径 5.X向右走出最大路径
         *
         * @param x
         */
        public static Info process(TreeNode x) {
            if (x == null) {
                return null;
            }
            Info left = process(x.left);
            Info right = process(x.right);

            int p1 = -1;
            if (left != null) {
                p1 = left.allMax;
            }
            int p2 = -1;
            if (right != null) {
                p2 = right.allMax;
            }
            int p3 = x.value;
            int p4 = -1;
            if (left != null) {
                p4 = x.value + left.fromHeadMax;
            }
            int p5 = -1;
            if (right != null) {
                p5 = x.value + right.fromHeadMax;
            }


            int fromHeadMax = Math.max(Math.max(p4, p5), p3);
            int allMax = Math.max(fromHeadMax, Math.max(p1, p2));
            return new Info(allMax, fromHeadMax);
        }

        public static class Info {
            int allMax;
            int fromHeadMax;

            public Info(int allMax, int fromHeadMax) {
                this.allMax = allMax;
                this.fromHeadMax = fromHeadMax;
            }
        }
    }

    /**
     * 路径可以从任何节点出发，到任何节点，返回最大路径和
     */
    public static class MaxSumInTree3 {
        /**
         * 之前路径上的节点累加和
         * a.X 无关 1.左树有最大路径 2.右树有最大路径
         * b.X 有关 3.X自身就是最大路径 4.X向左走出最大路径 5.X向右走出最大路径 6.X既往左又往右走出最大路径
         *
         * @param x
         */
        public static MaxSumInTree2.Info process(TreeNode x) {
            if (x == null) {
                return null;
            }
            MaxSumInTree2.Info left = process(x.left);
            MaxSumInTree2.Info right = process(x.right);

            int p1 = -1;
            if (left != null) {
                p1 = left.allMax;
            }
            int p2 = -1;
            if (right != null) {
                p2 = right.allMax;
            }
            int p3 = x.value;
            int p4 = -1;
            if (left != null) {
                p4 = x.value + left.fromHeadMax;
            }
            int p5 = -1;
            if (right != null) {
                p5 = x.value + right.fromHeadMax;
            }

            int p6 = -1;
            if (right != null && left != null) {
                p6 = x.value + right.fromHeadMax + left.fromHeadMax;
            }


            int fromHeadMax = Math.max(Math.max(p4, p5), p3);
            int allMax = Math.max(Math.max(fromHeadMax, p6), Math.max(p1, p2));
            return new MaxSumInTree2.Info(allMax, fromHeadMax);
        }

    }
}
