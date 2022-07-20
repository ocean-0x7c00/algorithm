package org.linkedlist;

import org.model.Node;

/**
 * 给定两个有序链表的头节点head1和head2，
 * 返回合并之后的大链表，要求依然有序
 * 例子     1 -> 3 -> 3 -> 5 -> 7          2 -> 2 -> 3 -> 3-> 7
 * 返回     1 -> 2 -> 2 -> 3 -> 3 -> 3 -> 3 -> 5 -> 7 -> 7
 */
public class Code04_MergeTwoSortedLinkedList {
    /**
     * p1->l1
     * p2->l2
     * 同时遍历两个list.
     * p1.value<p2.value,移动p1
     * p1.value>p2.value,移动p2
     * p1.value==p2.value,同时移动p1，p2
     *
     * @param l1
     * @param l2
     * @return
     */
    public static Node mergeTwoLists(Node l1, Node l2) {
        if (l1 == null && l2 == null) {
            return l1;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }


        Node p1 = l1;
        Node p2 = l2;
        Node head = null;
        Node last = null;
        if (p1.value == p2.value) {
            head = p1;
            Node p1Next = p1.next;
            p1.next = p2;
            p2 = p2.next;
            p1 = p1Next;
            last = p2;
        } else {
            head = p1.value < p2.value ? p1 : p2;
            last = p1.value < p2.value ? p1 : p2;

            p1 = p1.value < p2.value ? p1.next : p1;
            p2 = p2.value < p1.value ? p2.next : p2;
        }

        while (p1 != null || p2 != null) {
            if (p1 != null && p2 != null) {
                if (p1.value == p2.value) {
                    last.next = p2;
                    last = p2;
                    p2 = p2.next;
                } else {
                    last.next = p1.value < p2.value ? p1 : p2;
                    last = p1.value < p2.value ? p1 : p2;
                    p1 = p1.value < p2.value ? p1.next : p1;
                    p2 = p2.value < p1.value ? p2.next : p2;
                }
            }

            if (p1 == null && p2 != null) {
                last.next = p2;
                p2 = p2.next;
            }

            if (p1 != null && p2 == null) {
                last.next = p1;
                p1 = p1.next;
            }

        }


        return head;
    }


    public static void main(String[] args) {
        Node l1 = Node.creatNodeToTail(new int[]{1, 3, 3, 5, 7});
        Node l2 = Node.creatNodeToTail(new int[]{2, 2, 3, 3, 7});
        Node head = mergeTwoLists(l1, l2);
        Node.printNode(head);
    }
}
