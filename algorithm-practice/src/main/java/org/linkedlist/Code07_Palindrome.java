package org.linkedlist;

import org.model.Node;

/**
 * 给定一个单链表的头节点head，请判断该链表是否为回文结构。
 */
public class Code07_Palindrome {
    public static boolean isPalindrome(Node head) {

        if (head == null) {
            return false;
        }

        if (head.next == null) {
            return true;
        }

        Node L = head;
        Node midNode = getMidNode(head);
        Node R = reverse(midNode.next);
        Node next = R;
        midNode.next = null;

        boolean result = true;
        while (L != null && R != null) {
            if (L.value!=R.value){
                result=false;
                break;
            }
            L = L.next;
            R = R.next;
        }

        Node reverse = reverse(next);
        midNode.next = reverse;
        return result;
    }

    public static Node getMidNode(Node head) {
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

    public static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node last = null;
        while (head != null) {
            Node next = head.next;
            head.next = last;
            last = head;
            head = next;
        }
        return last;
    }

    public static void main(String[] args) {

//        int[] arr = {1, 2, 3};
        int[] arr = {1, 1, 2, 1};
//        int[] arr = {1, 2, 3, 3, 2, 1};
//        int[] arr = {1, 2, 3, 2, 1};
        Node node = Node.creatNodeToTail(arr);

        System.out.println(isPalindrome(node));
        System.out.println();
    }
}
