package org.tree;

import org.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树的序列化与反序列化
 * <p>
 * 只有先序、后序和层序遍历才能唯一的反序列化一颗树
 */
public class Lesson12_02SerializeAndReconstructTree {
    /**
     * 先序方式序列化
     *
     * @param head
     * @return
     */
    public static Queue<String> preSerial(TreeNode head) {
        Queue<String> queue = new LinkedList<>();
        pres(head, queue);
        return queue;
    }

    /**
     * 先序
     *
     * @param head
     * @param ans
     */
    public static void pres(TreeNode head, Queue<String> ans) {
        if (head == null) {
            ans.offer(null);
        } else {
            ans.offer(getValue(head));
            pres(head.left, ans);
            pres(head.right, ans);
        }

    }

    /**
     * 先序的方式反序列化
     *
     * @param preQueue
     * @return
     */
    public static TreeNode buildByPreQueue(Queue<String> preQueue) {
        if (preQueue == null || preQueue.size() == 0) {
            return null;
        }
        return preb(preQueue);
    }

    public static TreeNode preb(Queue<String> queue) {

        String value = queue.poll();
        if (value == null) {
            return null;
        }

        TreeNode head = new TreeNode(Integer.valueOf(value));
        head.left = preb(queue);
        head.right = preb(queue);
        return head;

    }

    /**
     * 后序方式序列化
     *
     * @param head
     * @return
     */
    public static Queue<String> posSerial(TreeNode head) {
        Queue<String> queue = new LinkedList<>();
        pos(head, queue);
        return queue;
    }

    public static void pos(TreeNode head, Queue<String> ans) {
        if (head == null) {
            ans.offer(null);
        } else {
            pos(head.left, ans);
            pos(head.right, ans);
            ans.offer(getValue(head));
        }
    }

    /**
     * 后序的方式反序列化
     *
     * @param prelist
     * @return
     */
    public static TreeNode buildByPosQueue(Queue<String> prelist) {
        if (prelist == null || prelist.size() == 0) {
            return null;
        }
        Stack<String> stack = new Stack<>();
        //左右头 -> 头右左
        while (!prelist.isEmpty()) {
            stack.push(prelist.poll());
        }
        return posb(stack);
    }

    public static TreeNode posb(Stack<String> stack) {
        String value = stack.pop();
        if (value == null) {
            return null;
        }

        TreeNode head = new TreeNode(Integer.valueOf(value));
        head.right = posb(stack);
        head.left = posb(stack);
        return head;
    }

    /**
     * 层序方式序列化
     *
     * @param head
     * @return
     */
    public static Queue<String> levelSerial(TreeNode head) {
        Queue<String> ans = new LinkedList<>();
        if (head == null) {
            ans.offer(null);
        } else {
            ans.offer(getValue(head));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(head);
            while (!queue.isEmpty()) {
                head = queue.poll();
                if (head.left != null) {
                    ans.offer(getValue(head.left));
                    queue.offer(head.left);
                } else {
                    ans.offer(null);
                }
                if (head.right != null) {
                    ans.offer(getValue(head.right));
                    queue.offer(head.right);
                } else {
                    ans.offer(null);
                }

            }
        }
        return ans;
    }

    /**
     * 中序的方式反序列化
     *
     * @param levelList
     * @return
     */
    public static TreeNode buildByLevelQueue(Queue<String> levelList) {
        if (levelList == null || levelList.size() == 0) {
            return null;
        }
        TreeNode head = createTreeNode(levelList.poll());
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        TreeNode node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            node.left = createTreeNode(levelList.poll());
            node.right = createTreeNode(levelList.poll());
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return head;
    }


    private static String getValue(TreeNode treeNode) {
        return String.valueOf(treeNode.value);
    }


    public static TreeNode createTreeNode(String val) {
        if (val == null) {
            return null;
        }
        return new TreeNode(Integer.valueOf(val));
    }

    /**
     * 随机生成一个二叉树
     *
     * @param maxLevel
     * @param maxValue
     * @return
     */
    public static TreeNode generateRandomBST(int maxLevel, int maxValue) {
        return null;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);


        Queue<String> queue = preSerial(node);


        TreeNode treeNode = buildByPreQueue(queue);
        System.out.println();
    }
}
