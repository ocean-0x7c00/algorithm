package model;

/**
 * 双链表节点
 */
public class DoubleNode {
    public int value;

    public DoubleNode pre;

    public DoubleNode next;

    public DoubleNode() {
    }

    public DoubleNode(int value) {
        this.value = value;
    }

    public static DoubleNode creatNodeToTail(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new DoubleNode();
        }
        DoubleNode head = new DoubleNode(arr[0]);
        DoubleNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            DoubleNode node = new DoubleNode(arr[i]);
            node.pre = cur;
            cur.next = node;
            cur = node;
        }

        return head;
    }

    public static DoubleNode creatNodeToHead(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new DoubleNode();
        }
        DoubleNode head = new DoubleNode(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            DoubleNode node = new DoubleNode(arr[i]);
            head.pre = node;
            node.next = head;
            head = node;
        }
        return head;
    }

    public static void printNextNode(DoubleNode node) {
        while (node != null) {
            System.out.print(node.value + "\t");
            node = node.next;
        }
        System.out.println();
    }

    public static DoubleNode getTailNode(DoubleNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        DoubleNode tail = null;
        while (node != null) {
            tail = node;
            node = node.next;
        }

        return tail;
    }

    public static void printPreNode(DoubleNode node) {
        while (node != null) {
            System.out.print(node.value + "\t");
            node = node.pre;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        DoubleNode node = creatNodeToHead(arr);
        printNextNode(node);
        printPreNode(getTailNode(node));
    }
}
