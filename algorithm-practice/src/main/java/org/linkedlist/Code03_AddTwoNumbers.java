package org.linkedlist;

import org.model.Node;

/**
 * 给定两个链表的头节点head1和head2，
 * <p>
 * 认为从左到右是某个数字从低位到高位，返回相加之后的链表
 *
 * <p>
 * 例子     4 -> 3 -> 6        2 -> 5 -> 3
 * 返回     6 -> 8 -> 9
 * 解释     634 + 352 = 986
 * <p>
 * <p>
 * 思路
 * 最主要的是找到最长的list
 */
public class Code03_AddTwoNumbers {
    public static Node addNumbers(Node n1, Node n2) {
        if (n1 == null && n2 == null) {
            return null;
        }
        if (n1 == null) {
            return n2;
        }
        if (n2 == null) {
            return n1;
        }

        //找出长的list
        Node l = findLongList(n1, n2) == n1 ? n1 : n2;
        Node s = findLongList(n1, n2) == n1 ? n2 : n1;

        Node p1 = l;
        Node p2 = s;
        int carry = 0;
        Node last = null;
        while (p1 != null) {
            if (p2 != null) {
                int sum = p1.value + p2.value + carry;
                carry = sum / 10;
                p1.value = sum % 10;
            }

            if (p2 == null && carry == 0) {
                return l;
            }


            if (p2 == null && carry != 0) {
                int sum = p1.value + carry;
                carry = sum / 10;
                p1.value = sum % 10;
            }
            last = p1;
            p1 = p1.next;
            if (p2 != null) {
                p2 = p2.next;
            }
        }

        if (carry != 0) {
            Node node = new Node(1);
            last.next = node;
        }
        return l;
    }

    public static Node findLongList(Node n1, Node n2) {
        Node cur1 = n1;
        Node cur2 = n2;
        while (cur1 != null) {
            if (cur1.next == null && cur2.next != null) {
                return n2;
            }
            if (cur1.next != null && cur2.next == null) {
                return n1;
            }

            //
//            if (cur1.next == null && cur2.next == null) {
//                return n1;
//            }

            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return n1;

    }

    public static void main(String[] args) {

        Node num1 = Node.createNodeToHead(new int[]{5, 5, 5});
        Node num2 = Node.createNodeToHead(new int[]{5, 5, 5});
        Node result = addNumbers(num1, num2);
        Node.printNode(result);

//        Node.printNode(findLongList(num1, num2));
    }

}
