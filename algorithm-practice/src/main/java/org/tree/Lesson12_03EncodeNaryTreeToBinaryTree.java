package org.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * N叉树如何通过二叉树来序列化、并完成反序列化
 * <p>
 * https://leetcode.com/problems/encode-n-ary-tree-to-binary-tree
 * https://leetcode.cn/problems/encode-n-ary-tree-to-binary-tree/
 */
public class Lesson12_03EncodeNaryTreeToBinaryTree {
    public static List<Node> de(TreeNode root) {
        List<Node> children = new ArrayList<>();
        while (root != null) {
            Node node = new Node(root.val, de(root.left));
            children.add(node);
            root = root.right;
        }
        return children;
    }

    /**
     * Encodes an n-ary tree to a binary tree.
     *
     * @param root
     * @return
     */
    public TreeNode encode(Node root) {
        if (root == null) {
            return null;
        }
        TreeNode head = new TreeNode(root.val);
        head.left = en(root.children);
        return head;
    }

    public TreeNode en(List<Node> nodes) {
        TreeNode head = null;
        TreeNode cur = null;
        for (Node node : nodes) {
            TreeNode treeNode = new TreeNode(node.val);
            if (head == null) {
                head = treeNode;
            } else {
                cur.right = treeNode;
            }
            cur = treeNode;
            cur.left = en(node.children);

        }
        return head;
    }

    /**
     * Decodes your binary tree to an n-ary tree.
     *
     * @param root
     * @return
     */
    public Node decode(TreeNode root) {
        if (root == null) {
            return null;
        }
        return new Node(root.val, de(root.left));
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
