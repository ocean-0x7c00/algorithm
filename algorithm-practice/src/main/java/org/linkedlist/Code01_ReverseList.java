package org.linkedlist;

import org.model.DoubleNode;
import org.model.Node;

/**
 * 逆序链表
 */
public class Code01_ReverseList {

    /**
     * 逆序单链表
     *
     * @param head
     * @return
     */
    public static Node reverseList(Node head) {
        //当前节点为空或下一个节点为空
        if (head == null || head.next == null) {
            return head;
        }

        Node cur = null;
        while (head != null) {
            Node next = head.next;
            head.next = cur;
            cur = head;
            head = next;
        }
        return cur;
    }


    /**
     * 逆序双链表
     *
     * @param head
     * @return
     */
    public static DoubleNode reverseList(DoubleNode head) {
        //当前节点为空或下一个节点为空
        if (head == null || head.next == null) {
            return head;
        }

        DoubleNode cur = null;
        while (head != null) {
            DoubleNode next = head.next;
            head.next = cur;
            head.pre = next;
            cur = head;
            head = next;
        }
        return cur;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5};
//        Node head = Node.creatNodeToTail(data);
//        Node.printNode(head);
//        Node.printNode(reverseList(head));


        DoubleNode doubleNode = DoubleNode.creatNodeToTail(data);
        DoubleNode.printNextNode(doubleNode);
        DoubleNode.printNextNode(reverseList(doubleNode));
    }
}
