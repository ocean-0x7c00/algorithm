package org.linkedlist;

import org.model.Node;

/**
 * 删除给定的值
 */
public class Code02_DeleteGivenValue {
    public static Node delete(Node head, int value) {
        if (head == null) {
            return null;
        }
        Node last = null;
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            if (cur.value == value) {
                if (last == null) {
                    head = next;
                } else {
                    //删除操作
                    last.next = next;
                }
            } else {
                last = cur;
            }
            cur = next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 2, 2, 2, 3};
        Node head = Node.creatNodeToTail(arr);
//        Node.printNode(head);

        Node delete = delete(head, 2);
        Node.printNode(delete);
    }
}
