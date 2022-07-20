package org.model;

/**
 * 单链表节点
 */
public class Node {
    public int value;
    public Node next;

    public Node() {
    }

    public Node(int value) {
        this.value = value;
    }

    /**
     * 尾插法创建单链表
     */
    public static Node creatNodeToTail(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new Node();
        }

        Node head = new Node(arr[0]);
        Node tail = head;
        for (int i = 1; i < arr.length; i++) {
            Node next = new Node(arr[i]);
            tail.next = next;
            tail = next;
        }

        return head;
    }


    /**
     * 头插法创建单链表
     */
    public static Node createNodeToHead(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new Node();
        }

        Node head = new Node(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            Node node = new Node(arr[i]);
            node.next = head;
            head = node;
        }
        return head;
    }

    public static void printNode(Node node) {
        while (node != null) {
            System.out.print(node.value + "\t");
            node = node.next;
        }
        System.out.println();
    }
}
