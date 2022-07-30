package org.tree;

import org.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 按层遍历
 */
public class Lesson12_01LevelTraversalBT {

    /**
     * 层序遍历
     *
     * @param head
     */
    public static void level(TreeNode head) {
        if (head == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            System.out.println(treeNode.value);
            if (treeNode.left != null) {
                queue.offer(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.offer(treeNode.right);
            }
        }
    }


    /**
     * 求最大宽度
     *
     * @param head
     */
    public static int maxLevel(TreeNode head) {
        if (head == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);

        int max = 0;
        TreeNode curEnd = head;
        TreeNode nextEnd = null;
        int currentLevelNodes = 0;

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                queue.offer(cur.left);
                nextEnd = cur.left;
            }

            if (cur.right != null) {
                queue.offer(cur.right);
                nextEnd = cur.right;
            }
            currentLevelNodes++;
            if (curEnd == nextEnd) {
                curEnd = nextEnd;
                max = Math.max(currentLevelNodes, max);
                currentLevelNodes = 0;
            }
        }

        return max;
    }
}
