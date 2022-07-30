package org.tree;

/**
 * 求二叉树某个节点的后继节点
 * 二叉树结构如下定义：
 * Class Node {
 * V value;
 * Node left;
 * Node right;
 * Node parent;
 * }
 * 给你二叉树中的某个节点，返回该节点的后继节点
 */
public class Lesson12_04SuccessorNode {
    /**
     * 1.X节点有右树，右树的最左节点就是X的后继节点
     * 2.X节点没有右树，从X节点开始向上找父节点，看父节点是否是左树
     *
     * @param node
     * @return
     */
    public static Node getSuccessorNode(Node node) {
        if (node == null) {
            return null;
        }

        if (node.right != null) {
            Node cur = node.right;
            while (cur != null && cur.left != null) {
                cur = cur.left;
            }
            return cur;

        } else {
            Node parent = node.parent;
            while (parent != null && parent.right == node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }

    }

    static class Node<V> {
        V value;
        Node left;
        Node right;
        Node parent;
    }
}
