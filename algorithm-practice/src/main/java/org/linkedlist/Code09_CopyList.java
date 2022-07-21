package org.linkedlist;

/**
 * 一种特殊的单链表节点类描述如下
 * class Node { int value; Node next; Node rand; Node(int val) { value = val; } }
 * rand指针是单链表节点结构中新增的指针，rand可能指向链表中的任意一个节点，也可能指向null。
 * 给定一个由Node节点类型组成的无环单链表的头节点 head，请实现一个函数完成这个链表的复制，并返回复制的新链表的头节点。
 * 【要求】时间复杂度O(N)，额外空间复杂度O(1)
 */
public class Code09_CopyList {

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        Node cur = head;
        while (cur != null) {
            Node node = new Node(cur.val);
            Node next = cur.next;
            cur.next = node;
            node.next = next;
            next = node.next;
            cur = next;
        }

        cur = head;

        //链接rand
        while (cur != null) {

            Node rand = cur.random;
            if (rand != null) {
                cur.next.random = rand.next;

            }
            cur = cur.next.next;

        }
        //断开连接返回新的Node节点
        Node res = head.next;
        cur = head;
        while (cur != null) {
            Node next = cur.next.next;
            Node copy = cur.next;

            //要保证之前的Node不断开
            //Next pointer of node with label 7 from the original list was modified.
            cur.next = next;
            copy.next = (next != null) ? next.next : null;

            cur = next;

        }

        return res;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.next = n2;
        n2.next = n3;
        n3.random = n1;
        Node node = copyRandomList(n1);

        System.out.println();
    }

    public static class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
        }
    }
}


