package org.model;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 */
public class TreeNode {
    public int value;

    public TreeNode left;

    public TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }


    /**
     * @param arr
     * @return
     */
    public static TreeNode creatTreeNode(int[] arr) {
        Queue<Integer> data = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            data.offer(arr[i]);
        }
        TreeNode head = createNode(data.poll());
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);

        TreeNode node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            node.left = createNode(data.poll());
            node.right = createNode(data.poll());
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return head;
    }

    private static TreeNode createNode(Integer value) {
        if (value == null) {
            return null;
        }
        return new TreeNode(value);
    }


    /**
     * 先序遍历
     *
     * @param head
     */
    public static void prePrintTreeNode(TreeNode head) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);

        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            System.out.println(pop.value);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }

        }

    }


    /**
     * 后序遍历
     *
     * @param head
     */
    public static void postPrintTreeNode1(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            Stack<TreeNode> help = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                help.push(pop);
                if (pop.left != null) {
                    stack.push(pop.left);
                }
                if (pop.right != null) {
                    stack.push(pop.right);
                }
            }

            while (!help.isEmpty()) {
                System.out.println(help.pop());
            }
        }

    }


    /**
     * 看空间复杂度为O(1)的实现
     *
     * @param head
     */
    public static void postPrintTreeNode2(TreeNode head) {
        if (head != null) {
            TreeNode last = head;
            TreeNode cur = null;

            Stack<TreeNode> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                cur = stack.peek();

                if (cur.left != null && cur.left != last && cur.right != last) {
                    stack.push(cur.left);
                } else if (cur.right != null && cur.right != last) {
                    stack.push(cur.right);
                } else {
                    TreeNode node = stack.pop();
                    System.out.println(node.value);
                    last = cur;
                }


            }
        }

    }

    /**
     * 中序遍历
     *
     * @param head
     */
    public static void midPrintTreeNode(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    TreeNode pop = stack.pop();
                    System.out.println(pop.value);
                    head = head.right;
                }
            }
        }

    }


    /**
     * 层序遍历
     *
     * @param head
     */
    public static void layerPrintTreeNode(TreeNode head) {
        if (head != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(head);
            TreeNode curEnd = head;
            TreeNode nextEnd = null;
            int max = 0;
            int currentLevelNodes = 0;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                System.out.println(node.value);
                if (node.left != null) {
                    queue.offer(node.left);
                    nextEnd = node.left;
                } else {
                    queue.offer(null);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    nextEnd = node.right;
                } else {
                    queue.offer(null);
                }

                currentLevelNodes++;

                if (node == curEnd) {
                    max = Math.max(max, currentLevelNodes);
                    currentLevelNodes = 0;
                    curEnd = nextEnd;

                }

            }
        }
    }


    /**
     * 先序方式序列化
     *
     * @param head
     */
    public static void preSerializeTreeNode(TreeNode head) {
        Queue<String> queue = new LinkedList<>();
        pres(head, queue);
    }

    public static void pres(TreeNode head, Queue queue) {
        if (head == null) {
            queue.offer(head);
        } else {
            pres(head.left, queue);
            pres(head.right, queue);
            queue.offer(head.value);
        }
    }


    public static TreeNode buildByPreSerialize(Queue queue) {
        if (queue == null || queue.size() == 0) {
            return null;
        }

        return null;
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


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        TreeNode node = TreeNode.creatTreeNode(arr);
        System.out.println();
    }
}
