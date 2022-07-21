package org.linkedlist;

import org.model.Node;

/**
 * 快慢指针
 */
public class Code06_SlowAndFast {

    /**
     * 输入链表头节点，奇数长度返回中点，偶数长度返回上中点
     *
     * @param head
     * @return
     */
    public static Node midOrUpMidNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }


        Node slow = head.next;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 输入链表头节点，奇数长度返回中点，偶数长度返回下中点
     *
     * @param head
     * @return
     */
    public static Node midOrDownMidNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        //三个开始
        Node slow = head.next;
        Node fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    /**
     * 输入链表头节点，奇数长度返回中点前一个，偶数长度返回上中点前一个
     *
     * @param head
     * @return
     */
    public static Node midOrUpMidPreNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }

        Node slow = head;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    /**
     * 输入链表头节点，奇数长度返回中点前一个，偶数长度返回下中点前一个
     *
     * @param head
     * @return
     */
    public static Node midOrDownMidPreNode(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        if (head.next.next == null) {
            return head;
        }
        Node slow = head;
        Node fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6};//3
//        int[] arr = {1, 2, 3}; //2
//        int[] arr = {1, 2}; //1
        Node node = Node.creatNodeToTail(arr);

        Node midOrUpMidNode = midOrUpMidNode(node);
//        Node midOrDownMidNode = midOrDownMidNode(node);
//        Node midOrUpMidPreNode = midOrUpMidPreNode(node);
//        Node midOrDownMidPreNode = midOrDownMidPreNode(node);


        System.out.println(midOrUpMidNode.value);
//        System.out.println(midOrDownMidNode.value);
//        System.out.println(midOrUpMidPreNode.value);
//        System.out.println(midOrDownMidPreNode.value);
        System.out.println();
    }
}
